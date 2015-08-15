package unip.com.br.View;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.SystemClock;
import android.provider.Settings;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.LocationSource;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import unip.com.br.View.R;

public class GPSActivity extends FragmentActivity implements LocationListener {

    private SupportMapFragment mapFrag;
    private GoogleMap map;
    private LocationManager locationManager;
    private boolean allowNetWork;
    private Chronometer cronometro;
    private Button btnInciar;
    private Button btnPausar;
    private Button btnParar;
    private boolean isClickPause;
    private long tempoQuandoParado;
    private List<LatLng> listaLatLng;
    private Polyline polyline;
    private TextView txtInfoKm;
    private TextView txtInfoKal;
    double distancia;
    public static double vlrCalorias = 0.0175;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps);

        cronometro = (Chronometer) findViewById(R.id.chronometer);
        btnInciar = (Button) findViewById(R.id.btnIniciar);
        btnPausar = (Button) findViewById(R.id.btnPausar);
        btnParar = (Button) findViewById(R.id.btnParar);
        txtInfoKm = (TextView) findViewById(R.id.txtInfoKm);
        txtInfoKal = (TextView) findViewById(R.id.txtInfoKal);

        GoogleMapOptions options = new GoogleMapOptions();
        options.zOrderOnTop(true);

        mapFrag = SupportMapFragment.newInstance(options);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        ft.replace(R.id.llContainerGps, mapFrag);
        ft.commit();
    }

    @Override
    public void onResume() {
        super.onResume();

        listaLatLng = new ArrayList<>();

        allowNetWork = true;

        new Thread(){
            public void run(){
                while (mapFrag.getMap() == null){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        configMap();
                    }
                });
            }
        }.start();

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if(!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
            Intent it = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivity(it);
        }
        else {
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, this);
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
        }

        btnInciar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(isClickPause){
                    cronometro.setBase(SystemClock.elapsedRealtime() + tempoQuandoParado);
                    cronometro.start();
                    tempoQuandoParado = 0;
                    isClickPause = false;
                }
                else {
                    cronometro.setBase(SystemClock.elapsedRealtime());
                    cronometro.start();
                    tempoQuandoParado = 0;
                }
            }
        });

        btnPausar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(!isClickPause){
                    tempoQuandoParado = cronometro.getBase() - SystemClock.elapsedRealtime();
                }
                cronometro.stop();
                isClickPause = true;
            }
        });

        btnParar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                cronometro.stop();
                cronometro.setText("Total (00:00)");
                tempoQuandoParado = 0;
            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();
        locationManager.removeUpdates(this);
    }

    public void configMap() {
        map = mapFrag.getMap();
        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        final LatLng latLng = new LatLng(-22.9798349, -47.1479902);
        configLocation(latLng);

    }

    public void configLocation(LatLng latLng){
        CameraPosition cameraPosition = new CameraPosition.Builder().target(latLng).zoom(15).bearing(0).tilt(0).build();
        CameraUpdate update = CameraUpdateFactory.newCameraPosition(cameraPosition);

        map.setMyLocationEnabled(true);
        map.animateCamera(update);
        MyLocation myLocation = new MyLocation();

        map.setLocationSource(myLocation);
        myLocation.setLocation(latLng);
    }

    @Override
    public void onLocationChanged(Location location) {
        if(location.getProvider().equals(LocationManager.GPS_PROVIDER)){
            allowNetWork = false;
        }

        if(allowNetWork || location.getProvider().equals(LocationManager.GPS_PROVIDER)) {
            configLocation(new LatLng(location.getLatitude(), location.getLongitude()));
        }

        LatLng logLatLng = new LatLng(location.getLatitude(), location.getLongitude());

        listaLatLng.add(logLatLng);
        drawRoute();
        getDistance();
        getCalorias();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    public class MyLocation implements LocationSource{

        private OnLocationChangedListener listener;

        @Override
        public void activate(OnLocationChangedListener listener) {
         this.listener = listener;
        }

        @Override
        public void deactivate() {

        }

        public void setLocation (LatLng locationLatLng){
            Location location = new Location(LocationManager.GPS_PROVIDER);
            location.setLatitude(locationLatLng.latitude);
            location.setLongitude(locationLatLng.longitude);

            if(listener != null) {
                listener.onLocationChanged(location);
            }
        }
    }

    public void drawRoute(){
        PolylineOptions po;

        if(polyline == null){
            po = new PolylineOptions();
            for(LatLng latLng : listaLatLng){
                po.add(latLng);
            }

            po.color(Color.BLUE);
            polyline = map.addPolyline(po);
        }
        else{
            polyline.setPoints(listaLatLng);
        }
    }

    public void getDistance(){
        DecimalFormat df = new DecimalFormat("#.#");
        distancia = 0;

        for(int i  = 0, tam = listaLatLng.size(); i<tam; i++){
            if(i < tam - 1){
                distancia += distance(listaLatLng.get(i), listaLatLng.get(i+1));
            }
        }

        txtInfoKm.setText(df.format(distancia) + "Km");
    }

    public void getCalorias(){

        txtInfoKal.setText(calculaCalorias(getVelocidadeMedia(distancia,  cronometro.getBase()), 120, vlrCalorias) + "Kal");


    }

    public static double distance(LatLng StartP, LatLng EndP) {
        double lat1 = StartP.latitude;
        double lat2 = EndP.latitude;
        double lon1 = StartP.longitude;
        double lon2 = EndP.longitude;
        double dLat = Math.toRadians(lat2-lat1);
        double dLon = Math.toRadians(lon2-lon1);
        double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLon/2) * Math.sin(dLon/2);
        double c = 2 * Math.asin(Math.sqrt(a));
        return 6366000 * c/1000;
    }

    public String calculaCalorias(double velocidade, double peso, double vlrCalorias){
        double calorias = velocidade * peso * vlrCalorias;

        return String.valueOf(calorias);
    }

    public double getVelocidadeMedia(double distancia, double tempo){

        return (distancia / tempo);
    }
}
