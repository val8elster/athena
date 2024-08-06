package com.application.athena.data.services;

import com.application.athena.data.repositories.BookRepository;
import com.application.athena.data.valueobjects.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository repository;

    public List<Book> getAll() {
        return repository.findAll();
    }
}
