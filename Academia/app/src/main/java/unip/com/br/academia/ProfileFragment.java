package unip.com.br.academia;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.*;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginBehavior;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.login.widget.ProfilePictureView;

import unip.com.br.activity.AcademiaActivity;
import unip.com.br.R;


public class ProfileFragment extends Fragment{
    public static final String TAG = "ProfileFragment";

    //private TextView userNameView;
    private OnOptionsItemSelectedListener onOptionsItemSelectedListener;

    private Profile pendingUpdateForUser;
    private CallbackManager callbackManager;
    private ProfileTracker profileTracker;
    private AccessTokenTracker accessTokenTracker;

    LoginButton loginButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(false);
        callbackManager = CallbackManager.Factory.create();
        profileTracker = new ProfileTracker() {
            @Override
            protected void onCurrentProfileChanged(Profile oldProfile, Profile currentProfile) {
                setProfile(currentProfile);
            }
        };

        accessTokenTracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(
                    AccessToken oldAccessToken,
                    AccessToken currentAccessToken) {
                // On AccessToken changes fetch the new profile which fires the event on
                // the ProfileTracker if the profile is different
                Profile.fetchProfileForCurrentAccessToken();
            }
        };

        // Ensure that our profile is up to date
        Profile.fetchProfileForCurrentAccessToken();
        setProfile(Profile.getCurrentProfile());

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        //super.onCreateOptionsMenu(menu, inflater);
       // inflater.inflate(R.menu.options_profile, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean handled = false;
        OnOptionsItemSelectedListener listener = onOptionsItemSelectedListener;
        if (listener != null) {
            handled = listener.onOptionsItemSelected(item);
        }

        if (!handled) {
            handled = super.onOptionsItemSelected(item);
        }

        return handled;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile, parent, false);

        //userNameView = (TextView) v.findViewById(R.id.profileUserName);
        //profilePictureView = (ProfilePictureView) v.findViewById(R.id.profilePic);

        if (pendingUpdateForUser != null) {
            setProfile(pendingUpdateForUser);
            pendingUpdateForUser = null;
        }else {


            loginButton = (LoginButton) v.findViewById(R.id.login_button);
            loginButton.setReadPermissions("public_profile", "email", "user_friends");
            // If using in a fragment
            loginButton.setFragment(this);
            // Other app specific specialization

            // Callback registration
            loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
                @Override
                public void onSuccess(LoginResult loginResult) {
                    // App code
                    Profile.fetchProfileForCurrentAccessToken();
                }

                @Override
                public void onCancel() {
                    // App code
                    AccessToken.setCurrentAccessToken(null);
                }

                @Override
                public void onError(FacebookException exception) {
                    // App code
                    AccessToken.setCurrentAccessToken(null);
                    ;
                }
            });
        }
        return v;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        profileTracker.stopTracking();
        accessTokenTracker.startTracking();
    }

    public void setOnOptionsItemSelectedListener(OnOptionsItemSelectedListener listener) {
        this.onOptionsItemSelectedListener = listener;
    }

    private void setProfile(Profile profile) {
        if (/*userNameView == null || */!isAdded()) {
            // Fragment not yet added to the view. So let's store which user was intended
            // for display.
            pendingUpdateForUser = profile;
            return;
        }

        if (profile == null) {
            //userNameView.setText(R.string.greeting_no_user);

        } else {
            //userNameView.setText(String.format(getString(R.string.greeting_format),profile.getName()));
            Intent intent = new Intent(getActivity(), AcademiaActivity.class);
            startActivity(intent);
        }
    }

    public interface OnOptionsItemSelectedListener {
        boolean onOptionsItemSelected(MenuItem item);
    }
}
