package com.application.athena.data.services;

import com.application.athena.data.repositories.SeriesRepository;
import com.application.athena.data.valueobjects.Series;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeriesService {
    @Autowired
    private SeriesRepository repository;

    public List<Series> getAll() {
        return repository.findAll();
    }

    public Object getAllBooks() {
        return null; //TODO
    }
}
