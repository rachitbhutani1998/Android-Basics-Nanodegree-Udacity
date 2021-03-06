package com.example.android.inventory.data;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import com.example.android.inventory.data.ProductContract.ProductEntry;

/**
 * Created by Rachit on 12/12/2016.
 */
public class ProductProvider extends ContentProvider{
    public static final int PRODUCTS=200;
    public static final int PRODUCT_ID=201;
    private static final UriMatcher sUriMatcher =
            new UriMatcher(UriMatcher.NO_MATCH);

    static {
        sUriMatcher.addURI(ProductContract.CONTENT_AUTHORITY,ProductContract.PATH_PRODUCT,PRODUCTS);
        sUriMatcher.addURI(ProductContract.CONTENT_AUTHORITY,ProductContract.PATH_PRODUCT+"/#",PRODUCT_ID);
    }

    private ProductHelper mHelper;

    @Override
    public boolean onCreate() {
        mHelper = new ProductHelper(getContext());
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        SQLiteDatabase db = mHelper.getReadableDatabase();
        Cursor cursor;
        int match=sUriMatcher.match(uri);
        switch (match){
            case PRODUCTS:
                cursor=db.query(ProductEntry.TABLE_NAME,projection,null,null,
                                null,null,sortOrder);
                break;
            case PRODUCT_ID:
                selection = ProductEntry._ID + "=?";
                selectionArgs = new String[]{String.valueOf(ContentUris.parseId(uri))};
                cursor=db.query(ProductEntry.TABLE_NAME,projection,selection,selectionArgs,null,null,sortOrder);
                break;
            default:
                throw new IllegalArgumentException("Cannot query unknown URI "+uri);
        }
        cursor.setNotificationUri(getContext().getContentResolver(),uri);
        return cursor;
    }

    @Override
    public String getType(Uri uri) {
        final int match=sUriMatcher.match(uri);
        switch (match){
            case PRODUCTS:
                return ProductEntry.CONTENT_LIST_TYPE;
            case PRODUCT_ID:
                return ProductEntry.CONTENT_ITEM_TYPE;
            default:
                throw new IllegalArgumentException("Unknown URI ");
        }
    }

    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        final int match = sUriMatcher.match(uri);
        switch (match){
            case PRODUCTS:
                getContext().getContentResolver().notifyChange(uri,null);
                return insertProduct(uri,contentValues);
            default:
                throw new IllegalArgumentException("Insertion is not supported by "+uri);
        }
    }

    private Uri insertProduct(Uri uri, ContentValues values){
        SQLiteDatabase db=mHelper.getWritableDatabase();
        String name=values.getAsString(ProductEntry.COLUMN_PRODUCT_NAME);
        if(name==null){
            throw new IllegalArgumentException("No product Name Found");
        }
        Integer quantity = values.getAsInteger(ProductEntry.COLUMN_PRODUCT_QUANTITY);
        if(quantity<0){
            throw new IllegalArgumentException("No quantity given");
        }
        Integer price = values.getAsInteger(ProductEntry.COLUMN_PRODUCT_PRICE);
        if(price<0){
            throw new IllegalArgumentException("Product has no price");
        }
        String image=values.getAsString(ProductEntry.COLUMN_PRODUCT_IMAGE);
        if(image==null){
            throw new IllegalArgumentException("No image provided for product");
        }
        long id=db.insert(ProductEntry.TABLE_NAME,null,values);
        return ContentUris.withAppendedId(uri,id);
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        SQLiteDatabase db = mHelper.getWritableDatabase();
        int rowsDeleted;
        final int match = sUriMatcher.match(uri);
        switch (match) {
            case PRODUCTS:
                rowsDeleted = db.delete(ProductEntry.TABLE_NAME, selection, selectionArgs);
                break;
            case PRODUCT_ID:
                selection = ProductEntry._ID + "=?";
                selectionArgs = new String[]{String.valueOf(ContentUris.parseId(uri))};
                rowsDeleted=db.delete(ProductEntry.TABLE_NAME,selection,selectionArgs);
                break;
            default:
                throw new IllegalArgumentException("Cannot Delete");
        }
        if (rowsDeleted != 0){
            getContext().getContentResolver().notifyChange(uri, null);
    }
        return rowsDeleted;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String selection,
                      String[] selectionArgs) {
        final int match=sUriMatcher.match(uri);
        switch (match){
            case PRODUCTS:
                return updateProduct(contentValues,selection,selectionArgs);
            case PRODUCT_ID:
                selection=ProductEntry._ID+"=?";
                selectionArgs=new String[]{String.valueOf(ContentUris.parseId(uri))};
                getContext().getContentResolver().notifyChange(uri,null);
                return updateProduct(contentValues,selection,selectionArgs);
            default:
                throw new IllegalArgumentException("Data cannot be updated");
        }
    }
    private int updateProduct(ContentValues values,String selection,String[] selectionArgs){
        if(values.containsKey(ProductEntry.COLUMN_PRODUCT_NAME)){
            String name = values.getAsString(ProductEntry.COLUMN_PRODUCT_NAME);
            if (name==null){
                throw new IllegalArgumentException("No product name");
            }
        }
        if(values.containsKey(ProductEntry.COLUMN_PRODUCT_PRICE)){
            Integer price=values.getAsInteger(ProductEntry.COLUMN_PRODUCT_PRICE);
            if(price!=null&&price<0){
                throw new IllegalArgumentException("Price not set");
            }
        }
        if(values.containsKey(ProductEntry.COLUMN_PRODUCT_QUANTITY)){
            Integer quantity = values.getAsInteger(ProductEntry.COLUMN_PRODUCT_QUANTITY);
            if(quantity!=null&&quantity<0){
                throw new IllegalArgumentException("Quantity is null");
            }
        }
        if(values.containsKey(ProductEntry.COLUMN_PRODUCT_IMAGE)){
            String image=values.getAsString(ProductEntry.COLUMN_PRODUCT_IMAGE);
            if (image==null){
                throw new IllegalArgumentException("Image not set for product");
            }
        }
        if (values.size()==0){
            return 0;
        }
        SQLiteDatabase db=mHelper.getWritableDatabase();
       return db.update(ProductEntry.TABLE_NAME,values,selection,selectionArgs);
    }
}
