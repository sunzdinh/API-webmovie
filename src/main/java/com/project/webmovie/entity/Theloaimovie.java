package com.project.webmovie.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@IdClass(Theloaimovie.TheloaimoviePK.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Theloaimovies")
public class Theloaimovie implements Serializable {

    @Id
    @Column(name="movie_id")
    private Long movieId;

    @Id
    @Column(name="theloai_id")
    private Long theloaiId;

    @ManyToOne
    @MapsId("movieId")
    @JoinColumn(name="movie_id", insertable = false, updatable = false)
    private Movie movie;

    @ManyToOne
    @MapsId("theloaiId")
    @JoinColumn(name="theloai_id", insertable = false, updatable = false)
    private Genre genre;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TheloaimoviePK implements Serializable {
        private Long movieId;
        private Long theloaiId;
    }
}
