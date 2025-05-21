package com.example.tvseries.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TVSeriesListItem {
    private int id;
    private String title;
    private Double imdbRating;
}
