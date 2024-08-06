package com.application.athena.data.repositories;

import com.application.athena.data.valueobjects.Series;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SeriesRepository extends JpaRepository<Series, UUID> {
}
