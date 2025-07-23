package com.project.webmovie.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Theloaimovies")

public class TheloaimovieEntity implements Serializable {
    @EmbeddedId
    private Theloaimovie id;
    @ManyToOne
    @MapsId("movieId")
    @JoinColumn(name="movie_id")
    private Movie movie;
    @ManyToOne
    @MapsId("theloaiId")
    @JoinColumn(name="theloai_id")
    private Genre genre;
}
