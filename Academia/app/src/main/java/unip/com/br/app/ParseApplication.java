package unip.com.br.app;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseInstallation;

/**
 * Created by Cleber on 13/11/2015.
 */
public class ParseApplication extends Application {

    private static String APPLICATION_ID = "XmN3NnmYBJ24i0NDijtgwWR02CXGCp3c8ffRLqSv";
    private static String CLIENT_KEY = "X5J3DnpFFvKTDP01p0EBhP0gB31U0CbErhlW9vkc";

    @Override
    public void onCreate(){
        super.onCreate();

        Parse.initialize(this, APPLICATION_ID, CLIENT_KEY);
        ParseInstallation.getCurrentInstallation().saveInBackground();
    }
}
