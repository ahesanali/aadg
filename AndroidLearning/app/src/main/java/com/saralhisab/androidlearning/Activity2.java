package com.saralhisab.androidlearning;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {
    private EditText txtName;
    private Button okBtn;

    private TableLayout mTableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        txtName = (EditText) findViewById(R.id.txt_fname);
        okBtn = (Button) findViewById(R.id.ok_btn);
        okBtn.setOnClickListener(okBtnClickListener);
//        mTableLayout = (TableLayout) findViewById(R.id.tableInvoices);
//        mTableLayout.setStretchAllColumns(true);
//        loadData();
        addHeaders();
        addData();

    }
    public void loadData() {
        int rows = 10;
        int leftRowMargin=0;
        int topRowMargin=0;
        int rightRowMargin=0;
        int bottomRowMargin = 0;

        int textSize = 0, smallTextSize =0, mediumTextSize = 0;

        // -1 means heading row
        for (int i = -1; i < rows; i++) {

            final TextView tv = new TextView(this);
            tv.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                    TableRow.LayoutParams.WRAP_CONTENT));

            tv.setGravity(Gravity.LEFT);
            tv.setPadding(5, 15, 0, 15);
            if (i == -1) {
                tv.setText("Inv.#");
                tv.setBackgroundColor(Color.parseColor("#f0f0f0"));
                tv.setTextSize(TypedValue.COMPLEX_UNIT_PX, smallTextSize);
            } else {
                tv.setBackgroundColor(Color.parseColor("#f8f8f8"));
                tv.setText("1");
                tv.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
            }


            // add table row

            final TableRow tr = new TableRow(this);
            tr.setId(i + 1);
            TableLayout.LayoutParams trParams = new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.WRAP_CONTENT);
            trParams.setMargins(leftRowMargin, topRowMargin, rightRowMargin, bottomRowMargin);
            tr.setPadding(0,0,0,0);
            tr.setLayoutParams(trParams);
            tr.addView(tv);
            mTableLayout.addView(tr, trParams);



        }
    }

    private TextView getTextView(int id, String title, int color, int typeface, int bgColor) {
        TextView tv = new TextView(this);
        tv.setId(id);
        tv.setText(title.toUpperCase());
        tv.setTextColor(color);
        tv.setPadding(20, 20, 20, 20);
        tv.setTypeface(Typeface.DEFAULT, typeface);
        tv.setBackgroundColor(bgColor);
        tv.setLayoutParams(getLayoutParams());

        //tv.setOnClickListener(this);
        return tv;
    }

    @NonNull
    private TableRow.LayoutParams getLayoutParams() {
        TableRow.LayoutParams params = new TableRow.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT);
        params.setMargins(2, 0, 0, 2);
        return params;
    }



    @NonNull
    private TableLayout.LayoutParams getTblLayoutParams() {
        return new TableLayout.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT);
    }

    /**
     * This function add the headers to the table
     **/
    public void addHeaders() {
        TableLayout tl = (TableLayout) findViewById(R.id.table);
        tl.setStretchAllColumns(true);
        TableRow tr = new TableRow(this);
        tr.setLayoutParams(getLayoutParams());
        tr.addView(getTextView(0, "COMPANY", Color.WHITE, Typeface.BOLD, Color.GRAY));
        tr.addView(getTextView(0, "OS", Color.WHITE, Typeface.BOLD, Color.GRAY));
        tr.addView(getTextView(0, "Version", Color.WHITE, Typeface.BOLD, Color.GRAY));
        tr.addView(getTextView(0, "Release", Color.WHITE, Typeface.BOLD, Color.GRAY));
        //tr.setBackgroundColor(Color.BLACK);
        tl.addView(tr, getTblLayoutParams());
    }
    String companies[] = {"Google", "Windows", "iPhone", "Nokia", "Samsung",
            "Google", "Windows", "iPhone", "Nokia", "Samsung",
            "Google", "Windows", "iPhone", "Nokia", "Samsung"};
    String os[] = {"Android", "Mango", "iOS", "Symbian", "Bada",
            "Android", "Mango", "iOS", "Symbian", "Bada",
            "Android", "Mango", "iOS", "Symbian", "Bada"};
    /**
     * This function add the data to the table
     **/
    public void addData() {
        int numCompanies = companies.length;
        TableLayout tl = (TableLayout)findViewById(R.id.table);
        for (int i = 0; i < numCompanies; i++) {
            TableRow tr = new TableRow(this);

            tr.setLayoutParams(getLayoutParams());
            tr.addView(getTextView(0, companies[i], Color.BLACK, Typeface.NORMAL, Color.WHITE));
            tr.addView(getTextView(0, os[i], Color.BLACK, Typeface.NORMAL, Color.WHITE));
            tr.addView(getTextView(0, os[i], Color.BLACK, Typeface.NORMAL, Color.WHITE));
            tr.addView(getTextView(0, os[i], Color.BLACK, Typeface.NORMAL, Color.WHITE));
            //tr.setBackgroundColor(Color.BLACK);
            tl.addView(tr, getTblLayoutParams());
        }
    }

    protected View.OnClickListener okBtnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(Activity2.this, "Firstname is"+txtName.getText().toString(), Toast.LENGTH_SHORT).show();
        }
    };

}
