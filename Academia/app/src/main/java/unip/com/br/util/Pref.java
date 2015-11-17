package unip.com.br.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Cleber on 13/11/2015.
 */
public class Pref {
    public static final String PREF_KEY_DATA = "unip.com.br.util.Pref.PREF_KEY_DATA";

    public static void savePrefKeyValue( Context context, String key, String value ){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor e = sp.edit();
        e.putString( key, value );
        e.apply();
    }
    public static String retrievePrefKeyValue( Context context, String key, String... defaultValue ){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences( context );
        String dValue = defaultValue != null && defaultValue.length > 0 ? defaultValue[0] : "";
        sp.getString(key, dValue );
        return( sp.getString( key, dValue ) );
    }
}
