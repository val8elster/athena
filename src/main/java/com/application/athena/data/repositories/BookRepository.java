package com.application.athena.data.repositories;

import com.application.athena.data.valueobjects.Book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
