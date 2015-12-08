package unip.com.br.helper;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParsePush;
import com.parse.SaveCallback;

import unip.com.br.app.AppConfig;

/**
 * Created by Cleber on 14/11/2015.
 */
public class ParseUtils {

    private static String TAG = Parse.class.getSimpleName();

    public static void verifyParseConfiguration(Context context){
        if(TextUtils.isEmpty(AppConfig.PARSE_APPLICATION_ID) || TextUtils.isEmpty(AppConfig.PARSE_CLIENT_KEY)){
            Toast.makeText(context, "Por favor configure seu parse Application ID and Parse Cliente Key in AppConfig", Toast.LENGTH_SHORT).show();
            ((Activity)context).finish();
        }
    }

    public static void registerParse(Context context){
        Parse.initialize(context, AppConfig.PARSE_APPLICATION_ID, AppConfig.PARSE_CLIENT_KEY);
        ParseInstallation.getCurrentInstallation().saveInBackground();

        ParsePush.subscribeInBackground(AppConfig.PARSE_CHANNEL, new SaveCallback() {
            @Override
            public void done(ParseException e) {
                Log.i(TAG, "Sucesso em salvar o Parse!");
            }
        });
    }

    public static void subscribeWithEmail(String email){
        ParseInstallation installation = ParseInstallation.getCurrentInstallation();

        installation.put("email", email);

        installation.saveInBackground();
    }
}
