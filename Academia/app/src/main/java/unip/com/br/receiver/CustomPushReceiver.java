package unip.com.br.receiver;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.parse.ParsePushBroadcastReceiver;

import org.json.JSONException;
import org.json.JSONObject;

import de.greenrobot.event.EventBus;
import unip.com.br.activity.AcademiaActivity;
import unip.com.br.helper.NotificationUtils;
import unip.com.br.util.ApplicationUtils;
import unip.com.br.util.Pref;
import unip.com.br.R;

/**
 * Created by Cleber on 13/11/2015.
 */
public class CustomPushReceiver extends ParsePushBroadcastReceiver {

    private final String TAG = CustomPushReceiver.class.getSimpleName();

    private NotificationUtils notificationUtils;

    private Intent parseIntent;

    public CustomPushReceiver() {
        super();
    }

    @Override
    protected void onPushReceive(Context context, Intent intent) {
        super.onPushReceive(context, intent);

        if(intent == null){
            return;
        }

        try{

            JSONObject json = new JSONObject(intent.getExtras().getString("com.parse.Data"));
            Log.e(TAG, "Push recebido: " +json);

            parseIntent = intent;

            parsePushJson(context, json);

        }catch (JSONException e){
            Log.e(TAG, "Erro Push: " +e.getMessage());
        }
    }

    @Override
    protected void onPushDismiss(Context context, Intent intent){
        super.onPushDismiss(context, intent);
    }

    @Override
    protected void onPushOpen(Context context, Intent intent){
        super.onPushOpen(context, intent);
    }

    private void parsePushJson(Context context, JSONObject json){
        try {

            boolean isBackground = json.getBoolean("is_background");
            JSONObject data = json.getJSONObject("data");
            String title = data.getString("title");
            String message = data.getString("message");

            if(!isBackground){
                Intent resultIntent = new Intent(context, AcademiaActivity.class);
                showNotificationMessage(context, title, message, resultIntent);
            }

        }catch (JSONException e) {
            Log.e(TAG, "Push message json exception: " + e.getMessage());
        }
    }

    private void showNotificationMessage(Context context, String title, String message, Intent intent) {

        notificationUtils = new NotificationUtils(context);

        intent.putExtras(parseIntent.getExtras());
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

        notificationUtils.showNotificationMessage(title, message, intent);
    }








   /* Thiengo
   private static final String TAG = "tag";

    @Override
    protected int getSmallIconId(Context context, Intent intent) {
        String teste = TAG;
        return (R.drawable.logo);
    }

    @Override
    protected void onPushReceive(Context context, Intent intent) {

        if(intent == null){
            return;
        }

        Pref.savePrefKeyValue(context.getApplicationContext(),
                Pref.PREF_KEY_DATA,
                intent.getExtras().getString("com.parse.Data"));

        if(ApplicationUtils.isMyApplicationTaskOnTop(context)){
            try{
                Log.i(TAG, "Recebeu msg");
                JSONObject pushData = new JSONObject(intent.getExtras().getString("com.parse.Data"));
                String alert = pushData.optString("alert", "Notification received.");

                EventBus.getDefault().post(alert);
            }catch (Exception e){
                Log.i(TAG, "ERRO "+e.getMessage());
            }
        }
        else{
            super.onPushReceive(context, intent);
        }

        super.onPushReceive(context, intent);
    }*/
}
