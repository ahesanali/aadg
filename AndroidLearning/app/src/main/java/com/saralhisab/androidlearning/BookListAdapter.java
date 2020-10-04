package com.saralhisab.androidlearning;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by del790 on 22-08-2016.
 */
public class BookListAdapter extends BaseAdapter {

    private ArrayList<Book> books;
    private Context mContext;

    public BookListAdapter(Context context,ArrayList<Book> books){
        this.books = books;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return books.size();
    }

    @Override
    public Object getItem(int position) {
        if(books != null)
            books.get(position);

        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater vi = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = vi.inflate(R.layout.book_list_item, null);
        Book book= books.get(position);
        TextView bookTItle = (TextView) convertView.findViewById(R.id.book_title);
        TextView authorName = (TextView) convertView.findViewById(R.id.author_name);
        TextView bookPrice = (TextView) convertView.findViewById(R.id.book_price);

        bookTItle.setText(book.getBookTitle());
        authorName.setText(book.getAuthor());
        bookPrice.setText(" Rs."+book.getPrice());

        return convertView;
    }
}
