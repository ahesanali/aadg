package com.saralhisab.androidlearning;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomListView extends AppCompatActivity {
    private ListView bookListView = null;
    private ArrayList<Book> books;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_custom_list_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bookListView = (ListView) findViewById(R.id.book_list_view);

        books = new ArrayList<Book>();
        books.add(new Book("Java 2 ","H. Schildt", 500.00));
        books.add(new Book("JavaScript","M. Mayor", 200.00));
        books.add(new Book("PHP","John", 200));

        BookListAdapter bookListAdapter = new BookListAdapter(this,books);

        bookListView.setAdapter(bookListAdapter);

        bookListView.setOnItemClickListener(listviewItemClkListenre);
    }

    private AdapterView.OnItemClickListener listviewItemClkListenre = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            Toast.makeText(CustomListView.this,"Book Tapped:"+books.get(position).getBookTitle(),Toast.LENGTH_SHORT).show();
        }
    };

}
