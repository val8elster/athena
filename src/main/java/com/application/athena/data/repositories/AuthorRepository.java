package com.application.athena.data.repositories;

import com.application.athena.data.valueobjects.Author;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthorRepository extends JpaRepository<Author, UUID> {
}
