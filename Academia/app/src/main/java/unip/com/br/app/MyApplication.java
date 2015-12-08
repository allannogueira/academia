package unip.com.br.app;

import android.app.Application;

import unip.com.br.helper.ParseUtils;

/**
 * Created by Cleber on 14/11/2015.
 */
public class MyApplication extends Application {

    private static MyApplication mInstance;

    @Override
    public void onCreate(){
        super.onCreate();

        mInstance = this;

        ParseUtils.registerParse(this);
    }

    public static synchronized  MyApplication getInstance(){
        return mInstance;
    }
}
