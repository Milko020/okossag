package com.example.tvseries.model;

import com.example.tvseries.enumeration.Genre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TVSeries {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private Integer premiere;
    private Double imdbRating;
   /* @OneToMany
    @JoinColumn(name="genre") ha a másik objektum osztály*/
    @Enumerated(EnumType.STRING)
    @Column(name = "genre")
    private Genre genre;

}
