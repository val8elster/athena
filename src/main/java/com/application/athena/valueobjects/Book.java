package com.application.athena.valueobjects;

import com.application.athena.valueobjects.enums.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Book {
    public Long isbn;

    private String title;
    private String author;
    private String publisher;
    private String publishedYear;
    private String description;
    private Language language;

    private List<Genre> genres;

    private CoverType cover;
    private String coverColour;
    private int pages;

    private float price;
    private boolean read;
    private int rating;

    public Book(Long isbn) {
        this.isbn = isbn;
    }
}
