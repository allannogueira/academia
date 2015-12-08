package unip.com.br.academia;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Parcel;
import android.util.Base64;

import com.facebook.FacebookSdk;

/**
 * Created by Cleber on 30/10/2015.
 */
public class UserInfoCache {
    private static final String USER_INFO_CACHE_FORMAT = "userInfo%d";
    private final String userInfoCacheKey;
    private final int slot;

    public UserInfoCache(int slotNumber) {
        userInfoCacheKey = String.format(USER_INFO_CACHE_FORMAT, slotNumber);
        slot = slotNumber;
    }
    public UserInfo get() {
        SharedPreferences prefs = getSharedPrefs();
        String encodedToken = prefs.getString(userInfoCacheKey, null);
        if(encodedToken == null) {
            return null;
        }
        return decodeUserInfo(encodedToken);
    }

    public void put(UserInfo userInfo) {
        SharedPreferences.Editor editor = getSharedPrefs().edit();
        String encodedToken = encodeUserInfo(userInfo);
        editor.putString(userInfoCacheKey, encodedToken);
        editor.apply();
    }

    public void clear() {
        SharedPreferences.Editor editor = getSharedPrefs().edit();
        editor.remove(userInfoCacheKey);
        editor.apply();
    }

    private static SharedPreferences getSharedPrefs() {
        return FacebookSdk.getApplicationContext().getSharedPreferences(
                "accessTokens",
                Context.MODE_PRIVATE);
    }

    private static UserInfo decodeUserInfo(String base64EncodedToken) {
        byte[] data = Base64.decode(base64EncodedToken, Base64.DEFAULT);
        Parcel parcel = Parcel.obtain();
        parcel.unmarshall(data, 0, data.length);
        parcel.setDataPosition(0);
        UserInfo userInfo = (UserInfo) parcel.readValue(UserInfo.class.getClassLoader());
        parcel.recycle();
        return userInfo;
    }

    private static String encodeUserInfo(UserInfo userInfo) {
        Parcel parcel = Parcel.obtain();
        parcel.writeValue(userInfo);
        byte[] data = parcel.marshall();
        parcel.recycle();
        return Base64.encodeToString(data, Base64.DEFAULT);
    }
}
