package com.application.athena.data.valueobjects;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Book {
    @Id
    private Long isbn;

    @Column(unique=true)
    public String title;

    @Column
    public String author;

    @Column
    public String description;

    @Column
    public LocalDate publicationDate;

    @Column
    public boolean isSeries;

    @ManyToOne
    @JoinColumn(name = "seriesId", referencedColumnName = "uuid")
    public Series series;
}
