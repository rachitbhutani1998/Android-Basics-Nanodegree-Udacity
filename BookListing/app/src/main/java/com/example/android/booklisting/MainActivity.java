package com.example.android.booklisting;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements LoaderManager.LoaderCallbacks<List<Books>> {


     String book_api =
            "https://www.googleapis.com/books/v1/volumes?q=android&maxResults=30";
    private int loader_id = 1;
    private BooksAdapter mAdapter;
    private TextView mEmptyTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //final String query = (String) fndViewById(R.id.search).toString();
        Button searchButton = (Button) findViewById(R.id.search_button);
        ListView earthquakeListView = (ListView) findViewById(R.id.list);
        mEmptyTextView = (TextView) findViewById(R.id.empty_view);
        mAdapter = new BooksAdapter(this, new ArrayList<Books>());

        earthquakeListView.setAdapter(mAdapter);
        LoaderManager loaderManager = null;

        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            mEmptyTextView.setVisibility(View.GONE);
            loaderManager = getLoaderManager();
            loaderManager.initLoader(loader_id, null, this);
        } else {
            View loadingIndicator = findViewById(R.id.loading_spinner);
            loadingIndicator.setVisibility(View.GONE);
            mEmptyTextView.setText("No Internet connection");
        }
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loader_id+=1;
                EditText editText =(EditText) findViewById(R.id.search);
                String query= editText.getText().toString();
                Log.i("MainActivity",query);
                book_api=
                        "https://www.googleapis.com/books/v1/volumes?q="+query+"&maxResults=30";
            Log.i("Main Activity","Button Clicked");
                LoaderManager loaderManager = null;

                ConnectivityManager connMgr = (ConnectivityManager)
                        getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
                if (networkInfo != null && networkInfo.isConnected()) {
                    mEmptyTextView.setVisibility(View.GONE);
                    loaderManager = getLoaderManager();
                    loaderManager.initLoader(loader_id, null, MainActivity.this);
                } else {
                    View loadingIndicator = findViewById(R.id.loading_spinner);
                    loadingIndicator.setVisibility(View.GONE);
                    mEmptyTextView.setText("No Internet connection");
                }
            }
        });
    }


    @Override
    public Loader<List<Books>> onCreateLoader(int i, Bundle bundle) {
        Log.i("MainActivity","Loader Created "+book_api);
        return new BookLoader(this, book_api);
    }

    @Override
    public void onLoadFinished(Loader<List<Books>> loader, List<Books> books) {
        mEmptyTextView.setText("No books");
        mAdapter.clear();
        ProgressBar progress = (ProgressBar) findViewById(R.id.loading_spinner);
        progress.setVisibility(View.GONE);
        if (books != null && !books.isEmpty()) {
            mAdapter.addAll(books);
            Log.i("MainActivity","Books Added");
        } else mEmptyTextView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onLoaderReset(Loader<List<Books>> loader) {
        mAdapter.clear();
        Log.i("MainActivity","Loader Reset");
    }
}