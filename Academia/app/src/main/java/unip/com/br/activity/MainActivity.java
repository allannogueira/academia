package unip.com.br.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;

import unip.com.br.R;

/**
 * Created by Cleber on 22/10/2015.
 */
public class MainActivity extends AppCompatActivity {
    private static final String SERVER_API_KEY = "AIzaSyBsC-Ual_LeXq-2MP7CuSaYf3tDr_uELBU";
    private static final String SENDER_ID = "737713613524";

    private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;

    private TextView tvTitle;
    private TextView tvMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvMessage = (TextView) findViewById(R.id.tvMessage);
    }

    private boolean checkPlayServices(){
        int resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        if(resultCode != ConnectionResult.SUCCESS){
            if(GooglePlayServicesUtil.isUserRecoverableError(resultCode)){
                GooglePlayServicesUtil.getErrorDialog(resultCode, this, PLAY_SERVICES_RESOLUTION_REQUEST).show();
            }
            else{
                Log.i("LOG","this device is not supported");
                finish();
            }
            return false;
        }
        return true;
    }
}
