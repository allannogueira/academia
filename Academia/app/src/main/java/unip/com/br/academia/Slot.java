package unip.com.br.academia;

import com.facebook.AccessToken;
import com.facebook.login.LoginBehavior;

/**
 * Created by Cleber on 30/10/2015.
 */
public class Slot {

    private UserInfo userInfo;
    private final UserInfoCache userInfoCache;
    private LoginBehavior loginBehavior;

    public Slot(int slotNumber, LoginBehavior loginBehavior) {
        this.loginBehavior = loginBehavior;
        this.userInfoCache = new UserInfoCache(slotNumber);
        this.userInfo = userInfoCache.get();
    }

    public LoginBehavior getLoginBehavior() {
        return loginBehavior;
    }

    public String getUserName() {
        return (userInfo != null) ? userInfo.getUserName() : null;
    }

    public AccessToken getAccessToken() {
        return (userInfo != null) ? userInfo.getAccessToken() : null;
    }

    public String getUserId() {
        return (userInfo != null) ? userInfo.getAccessToken().getUserId() : null;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo user) {
        userInfo = user;
        if (user == null) {
            return;
        }

        userInfoCache.put(user);
    }

    public void clear() {
        userInfo = null;
        userInfoCache.clear();
    }
}
