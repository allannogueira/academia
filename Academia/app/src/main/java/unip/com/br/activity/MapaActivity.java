package unip.com.br.activity;

import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import unip.com.br.R;


public class MapaActivity extends FragmentActivity {

    private SupportMapFragment mapFrag;
    private GoogleMap map;
    private Marker marker;
    private Polyline polyline;
    private List<LatLng> listLatLng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);

        GoogleMapOptions options = new GoogleMapOptions();
        options.zOrderOnTop(true);

        /*mapFrag = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapFragment);
        map = mapFrag.getMap();*/
        mapFrag = SupportMapFragment.newInstance(options);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        ft.replace(R.id.llContainer, mapFrag);
        ft.commit();
        //configMap();
    }

    @Override
    public void onResume(){
        super.onResume();

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
    }

    public void configMap(){
        map = mapFrag.getMap();
        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        listLatLng = new ArrayList<LatLng>();

        final LatLng latLng = new LatLng(-23.564224, -46.653156);

        CameraPosition cameraPosition = new CameraPosition.Builder().target(latLng).zoom(15).bearing(0).tilt(90).build();
        CameraUpdate update = CameraUpdateFactory.newCameraPosition(cameraPosition);
        map.animateCamera(update, 3000, new GoogleMap.CancelableCallback() {
            @Override
            public void onFinish() {
                Log.i("Script onFinish", "Script onFinish");
            }

            @Override
            public void onCancel() {
                Log.i("Script onCancel", "Script onCancel");
            }
        });

        //Maker
        //customAddMarker(new LatLng(-23.564224, -46.653156), " Marcador 1o" , "O marcador 1 foi posicionado");
        //customAddMarker(new LatLng(-23.564205, -46.653102), " Marcador 1o" , "O marcador 1 foi posicionado");

        //Events

       /* map.setOnCameraChangeListener(new GoogleMap.OnCameraChangeListener(){

            @Override
            public void onCameraChange(CameraPosition cameraPosition){
                Log.i("Script", "setOnCameraChangeListener");

               if(marker != null){
                    marker.remove();
                }
                customAddMarker(new LatLng(cameraPosition.target.latitude, cameraPosition.target.longitude), "1: Marcador Alterado" , "O marcador foi reposicionado");

            }
        });*/

        map.setOnMapClickListener(new GoogleMap.OnMapClickListener(){

            @Override
            public void onMapClick(LatLng latLng1){
                Log.i("Script", "setOnMapClickListener");

                if(marker != null){
                    marker.remove();
                }
                customAddMarker(new LatLng(latLng1.latitude, latLng1.longitude),"2: Marcador Alterado", "O marcador foi reposicionado");

                listLatLng.add(latLng1);

                drawRoute();
            }
        });

        map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {

            @Override
            public boolean onMarkerClick(Marker marker){
                Log.i("Script", "3: Marker: "+marker.getTitle());
                return false;

            }

        });

        map.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener(){
            @Override
            public void onInfoWindowClick(Marker marker){
                Log.i("Script", "4: Marker: "+marker.getTitle());
            }
        });
    }

    public void customAddMarker(LatLng latLng, String title, String snippet){
        MarkerOptions options = new MarkerOptions();
       options.position(latLng).title(title).snippet(snippet).draggable(true);

        marker = map.addMarker(options);
    }

    public void drawRoute(){
        PolylineOptions po;

        if(polyline == null){
            po = new PolylineOptions();
            for(LatLng latLng : listLatLng){
                po.add(latLng);
            }

            po.color(Color.BLUE);
            polyline = map.addPolyline(po);
        }
        else{
            polyline.setPoints(listLatLng);
        }
    }

    public void getDistance(View view){
        double distancia = 0;

        for(int i  = 0, tam = listLatLng.size(); i<tam; i++){
            if(i < tam - 1){
                distancia += distance(listLatLng.get(i), listLatLng.get(i+1));
            }
        }

        Toast.makeText(MapaActivity.this, "Distancia: "+distancia+"Mt", Toast.LENGTH_LONG).show();
    }

    public void getLocation(View view){
        Geocoder gc = new Geocoder(MapaActivity.this);

        List<Address> addressList = new ArrayList<Address>();
        try {
            addressList = gc.getFromLocation(listLatLng.get(listLatLng.size() - 1).latitude,
                    listLatLng.get(listLatLng.size() - 1).longitude, 1);

            String address = "Rua: "+addressList.get(0).getThoroughfare() + "\n";
            address += "Cidade: "+addressList.get(0).getSubAdminArea() + "\n";
            address += "Estado: "+addressList.get(0).getAdminArea() + "\n";
            address += "Cidade: "+addressList.get(0).getCountryName() + "\n";

            Toast.makeText(MapaActivity.this, "Local: "+address, Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        return 6366000 * c;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mapa, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
