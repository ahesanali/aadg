package com.saralhisab.androidlearning;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.SharedPreferencesCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SharedPreferenceActivity extends AppCompatActivity
implements View.OnClickListener{

    private static final String PREFS_NAME = "AndroidLearning";
    private static final String BUSINESS_NAME_KEY = "business_name_key";

    private EditText businessName;
    private Button savePreference,retrievePreference;
    private TextView businessNamePrefsVal;

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //initialize views controls
        businessName = (EditText) findViewById(R.id.business_name);
        savePreference = (Button) findViewById(R.id.save_preference);
        retrievePreference = (Button) findViewById(R.id.retriev_preference);
        businessNamePrefsVal = (TextView) findViewById(R.id.preference_value);
        //set click listener
        savePreference.setOnClickListener(this);
        retrievePreference.setOnClickListener(this);

        //initialize shared preference object
        //Here MODE_PRIVATE means:File creation mode: the default mode, where the created file can only be accessed by the calling application
        sharedPreferences = getSharedPreferences(PREFS_NAME,MODE_PRIVATE);
    }


    @Override
    public void onClick(View view) {
        int viewId = view.getId();

        switch (viewId){
            case R.id.save_preference:
                //store business name prefs
                //preparing editor
                SharedPreferences.Editor editor = sharedPreferences.edit();
                //retrieving value from text box and storing in shared prefs editor
                editor.putString(BUSINESS_NAME_KEY,businessName.getText().toString());
                //commit the prefs value to store in persistence storage.
                editor.commit();
                break;
            case R.id.retriev_preference:
                //retrieve business name prefs
                // here "No business" is a default value if prefs doesn't have stored any value by user
                String businessName = sharedPreferences.getString(BUSINESS_NAME_KEY,"No business");
                businessNamePrefsVal.setText(businessName);
                break;
            default:

        }
    }
}
