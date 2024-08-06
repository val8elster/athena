package com.application.athena.data.valueobjects;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Series {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @Column(unique = true)
    public String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "authorId", referencedColumnName = "uuid")
    public Author author;

    public Series(String name, Author author) {
        this.name = name;
        this.author = author;
    }

    public Series() {}
}