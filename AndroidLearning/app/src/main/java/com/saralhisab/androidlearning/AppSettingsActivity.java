package com.saralhisab.androidlearning;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by ahesan on 19/02/18.
 */

public class AppSettingsActivity extends AppCompatActivity {
    //preferences keys
    public static final String BUSINESS_NAME_PREF_KEY = "business_name";
    public static final String BUSINESS_ADDRESS_PREF_KEY = "business_address";

    //preferences default values
    public static final String BUSINESS_NAME_PREF_DEF_VALUE = "";
    public static final String BUSINESS_ADDRESS_PREF_DEF_VALUE = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getFragmentManager().beginTransaction().replace(android.R.id.content, new SettingsPreferenceFragment()).commit();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.action_settings));
    }

    public static class SettingsPreferenceFragment extends PreferenceFragment
            implements SharedPreferences.OnSharedPreferenceChangeListener{

        private EditTextPreference businessName, businessAddress;
        @Override
        public void onCreate(final Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.settings_activity_preferences);

            PreferenceManager.setDefaultValues(getActivity(), R.xml.settings_activity_preferences, false);
            SharedPreferences sp = getPreferenceScreen().getSharedPreferences();

            //setting value while opening screen
            businessName = (EditTextPreference) findPreference(BUSINESS_NAME_PREF_KEY);
            businessName.setSummary(sp.getString(BUSINESS_NAME_PREF_KEY, BUSINESS_NAME_PREF_DEF_VALUE));

            businessAddress = (EditTextPreference) findPreference(BUSINESS_ADDRESS_PREF_KEY);
            businessAddress.setSummary(sp.getString(BUSINESS_ADDRESS_PREF_KEY, BUSINESS_ADDRESS_PREF_DEF_VALUE));
        }

        @Override
        public void onResume() {
            super.onResume();
            getPreferenceScreen().getSharedPreferences()
                    .registerOnSharedPreferenceChangeListener(this);
        }

        @Override
        public void onPause() {
            super.onPause();
            getPreferenceScreen().getSharedPreferences()
                    .unregisterOnSharedPreferenceChangeListener(this);
        }

        @Override
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {


            if (key.equals(BUSINESS_NAME_PREF_KEY)) {
                Preference preference = findPreference(key);
                // Set summary to be the user-description for the selected value
                preference.setSummary(sharedPreferences.getString(key,BUSINESS_NAME_PREF_DEF_VALUE));
            }else if (key.equals(BUSINESS_ADDRESS_PREF_KEY)) {
                Preference preference = findPreference(key);
                // Set summary to be the user-description for the selected value
                preference.setSummary(sharedPreferences.getString(key,BUSINESS_ADDRESS_PREF_DEF_VALUE));
            }
        }

    }
}
