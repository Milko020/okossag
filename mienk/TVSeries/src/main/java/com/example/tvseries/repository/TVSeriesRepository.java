package com.example.tvseries.repository;

import com.example.tvseries.model.TVSeries;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TVSeriesRepository extends JpaRepository<TVSeries, Integer> {
}
