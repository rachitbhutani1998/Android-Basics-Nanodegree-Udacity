package com.example.android.booklisting;

/**
 * Created by Rachit on 11/25/2016.
 */
public class Books {
    private String mTitle;
    private String mAuthor;
    private String mPublisher;
    public Books(String author,String title,String publisher){
        mPublisher=publisher;
        mTitle = title;
        mAuthor=author;
    }
    public String getPublisher(){
        return mPublisher;
    }
    public String getAuthor(){
        return mAuthor;
    }
    public String getTitle(){
        return mTitle;
    }
}
