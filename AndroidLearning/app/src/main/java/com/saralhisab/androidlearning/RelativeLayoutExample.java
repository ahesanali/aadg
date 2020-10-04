package com.saralhisab.androidlearning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class RelativeLayoutExample extends AppCompatActivity {
    private ListView menuListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative_layout_example);

        menuListView = (ListView)findViewById(R.id.menu_list);

         final String[] menuitems = {"Ice Cream","Punjabi Sabji"};
//        final String[] menuitems = this.getResources().getStringArray(R.array.menu_items);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,menuitems);

        menuListView.setAdapter(adapter);


        menuListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(RelativeLayoutExample.this,"item name: "+ menuitems[position],Toast.LENGTH_LONG).show();


            }
        });
    }
}
