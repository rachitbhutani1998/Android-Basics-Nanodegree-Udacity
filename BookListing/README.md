#Book Listing App
--------------------------
This BookListing application is the seventh project of Udacity's Android Basics Nanodegree.

As the application starts, It loads a list of android books from the [google_play_books_api](https://www.googleapis.com/books/v1/volumes?q=android&maxResults=30).

The app provides you a list of 30 android books. You can always change the category of books by entering your desire field in the given 
text field.

The application loads the list of books on a background thread and provides an EmptyView if no data is there to be displayed and a view for
connection problem if no internet connection is available for the application to work.

The concept of JSON parsing is used t get data from the books api.
