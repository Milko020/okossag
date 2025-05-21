package com.example.tvseries.dto;

import com.example.tvseries.enumeration.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TVSeriesRead {
    private int id;
    private String title;
    private Integer premiere;
    private Double imdbRating;
    private Genre genre;
}
