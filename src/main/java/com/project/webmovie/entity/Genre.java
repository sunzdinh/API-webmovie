package com.project.webmovie.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Genres")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id ;
    @Column(name="NAME")
    private String name ;
    @ManyToMany(mappedBy = "genreList")
    private List<Movie> movies;
}
