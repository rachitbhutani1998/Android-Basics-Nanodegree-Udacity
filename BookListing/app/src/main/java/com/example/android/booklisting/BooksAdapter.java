package com.example.android.booklisting;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Rachit on 11/25/2016.
 */
public class BooksAdapter extends ArrayAdapter<Books> {
    public BooksAdapter(Activity context, List<Books> books) {
        super(context, 0, books);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        Books currentBook = getItem(position);
        TextView author = (TextView) listItemView.findViewById(R.id.author_text);
        author.setText(currentBook.getAuthor());
        TextView title = (TextView) listItemView.findViewById(R.id.title_text);
        title.setText(currentBook.getTitle());
        TextView publisher = (TextView) listItemView.findViewById(R.id.publisher_text);
        publisher.setText(currentBook.getPublisher());
        return listItemView;
    }
}
