package com.application.athena.valueobjects;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Series {
    private String name;
    private String author;
    private List<Book> books;

    public Series(String name, String author) {
        this.name = name;
        this.author = author;
        this.books = new ArrayList<>();
    }
}
