package unip.com.br.academia;

import android.os.Parcel;
import android.os.Parcelable;

import com.facebook.AccessToken;

/**
 * Created by Cleber on 30/10/2015.
 */
public class UserInfo  implements Parcelable {
    private String userName;
    private AccessToken accessToken;

    public UserInfo(String userName, AccessToken accessToken) {
        this.userName = userName;
        this.accessToken = accessToken;
    }

    public String getUserName() {
        return userName;
    }

    public AccessToken getAccessToken() {
        return accessToken;
    }

    UserInfo(Parcel parcel) {
        this.userName = parcel.readString();
        this.accessToken = parcel.readParcelable(UserInfo.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(userName);
        dest.writeParcelable(accessToken, 0);
    }

    public static final Parcelable.Creator<UserInfo> CREATOR = new Parcelable.Creator() {

        @Override
        public UserInfo createFromParcel(Parcel source) {
            return new UserInfo(source);
        }

        @Override
        public UserInfo[] newArray(int size) {
            return new UserInfo[size];
        }
    };
}
