package unip.com.br.activity;


import android.app.Activity;
import android.os.Bundle;
import unip.com.br.academia.ProfileFragment;
import unip.com.br.academia.SettingsFragment;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;

import com.facebook.*;
import com.facebook.appevents.AppEventsLogger;

import unip.com.br.R;

public class LoginActivity extends FragmentActivity{

    private static final String SHOWING_SETTINGS_KEY = "Showing settings";

    private ProfileFragment profileFragment;
    private boolean isShowingSettings;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       FacebookSdk.sdkInitialize(getApplicationContext());

        setContentView(R.layout.activity_login);

        restoreFragments(savedInstanceState);

        if (savedInstanceState != null) {
            if (savedInstanceState.getBoolean(SHOWING_SETTINGS_KEY)) {
                showSettings();
            } else {
                showProfile();
            }
        } else {
            showProfile();
        }
    }

   @Override
    public void onBackPressed() {
        if (isShowingSettings()) {
            // This back is from the settings fragment
            showProfile();
        } else {
            // Allow the user to back out of the app as well.
            super.onBackPressed();
        }
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(SHOWING_SETTINGS_KEY, isShowingSettings());

        FragmentManager manager = getSupportFragmentManager();
        manager.putFragment(outState, ProfileFragment.TAG, profileFragment);
    }

    @Override
    protected void onResume() {
        super.onResume();

        profileFragment.setOnOptionsItemSelectedListener(new ProfileFragment.OnOptionsItemSelectedListener() {
            @Override
            public boolean onOptionsItemSelected(MenuItem item) {
                return handleOptionsItemSelected(item);
            }
        });

        // Call the 'activateApp' method to log an app event for use in analytics and advertising
        // reporting.  Do so in the onResume methods of the primary Activities that an app may be
        // launched into.
        AppEventsLogger.activateApp(this);
    }

    @Override
    protected void onPause() {
        super.onPause();

        profileFragment.setOnOptionsItemSelectedListener(null);

        // Call the 'deactivateApp' method to log an app event for use in analytics and advertising
        // reporting.  Do so in the onPause methods of the primary Activities that an app may be
        // launched into.
        AppEventsLogger.deactivateApp(this);
    }

    private void restoreFragments(Bundle savedInstanceState) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        if (savedInstanceState != null) {
            profileFragment = (ProfileFragment) manager.getFragment(savedInstanceState,
                    ProfileFragment.TAG);

        }

        if (profileFragment == null) {
            profileFragment = new ProfileFragment();
            transaction.add(R.id.fragmentContainer, profileFragment, ProfileFragment.TAG);
        }

        transaction.commit();
    }

    private void showSettings() {
        isShowingSettings = true;


    }

    private boolean isShowingSettings() {
        return isShowingSettings;
    }

    private void showProfile() {
        isShowingSettings = false;

       FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();


    }


    private boolean handleOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item_switch:
                showSettings();
                return true;
            default:
                return false;
        }
    }


}
