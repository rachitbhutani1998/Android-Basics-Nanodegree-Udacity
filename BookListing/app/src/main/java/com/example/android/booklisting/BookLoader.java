package com.example.android.booklisting;

import android.content.Context;
import android.content.AsyncTaskLoader;

import java.util.List;

/**
 * Created by Rachit on 11/25/2016.
 */
public class BookLoader extends AsyncTaskLoader<List<Books>> {

    private String mUrl;

    public BookLoader(Context context,String url){
        super(context);
        mUrl=url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<Books> loadInBackground() {
        if(mUrl==null){
            return null;
        }
        return BooksUtils.fetchBooksInfo(mUrl);
    }
}
