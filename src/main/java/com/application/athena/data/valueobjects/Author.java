package com.application.athena.data.valueobjects;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @Column
    public String firstName;

    @Column
    public String lastName;

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Author() {}
}