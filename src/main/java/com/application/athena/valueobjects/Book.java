package com.application.athena.valueobjects;

import com.application.athena.valueobjects.enums.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class Book {
    public Long isbn;

    private String title;
    private String author;
    private String publisher;
    private int publishedYear;
    private String description;
    private Language language;

    private List<Genre> genres;

    private CoverType cover;
    private Colour coverColour;
    private int pages;

    private float price;
    private LocalDate buyDate;
    private boolean read;
    private int rating;

    public Book(Long isbn) {
        this.isbn = isbn;
    }
}
