package com.saralhisab.androidlearning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.mynameismidori.currencypicker.CurrencyPicker;
import com.mynameismidori.currencypicker.CurrencyPickerListener;

public class CurrencyDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_demo);

        CurrencyPicker picker = CurrencyPicker.newInstance("Select Currency");  // dialog title
        picker.setListener(new CurrencyPickerListener() {
            @Override
            public void onSelectCurrency(String name, String code, String symbol, int flagDrawableResID) {
                // Implement your code here
                Log.d("CurrenctDEMO","Name:"+name+" code:"+code+" symbol:"+symbol);
            }
        });
        picker.show(getSupportFragmentManager(), "CURRENCY_PICKER");
    }
}
