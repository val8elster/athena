package com.application.athena.services;

import com.application.athena.valueobjects.*;
import com.application.athena.valueobjects.enums.Genre;

import java.util.ArrayList;
import java.util.List;

public class TempLogic {
    public Book currentBook;
    public List<Book> bookList;
    public List<Series> seriesList;

    public TempLogic() {
        bookList = new ArrayList<>();
        seriesList = new ArrayList<>();

        bookList.add(new Book(12345L));
        bookList.add(new Book(56789L));
        bookList.get(0).title = "Book 1";
        bookList.get(1).title = "Book 2";
        bookList.get(0).author = "John Doe";
        bookList.get(1).author = "Jane Doe";
        bookList.get(0).rating = 1;
        bookList.get(1).rating = 2;

        bookList.get(0).addGenre(Genre.FANTASY);
        bookList.get(0).addGenre(Genre.ROMANCE);
        bookList.get(0).setRead(true);

        seriesList.add(new Series("Series 1", "Jane Doe"));
        seriesList.add(new Series("Series 2", "Janey Doe"));
    }
}
