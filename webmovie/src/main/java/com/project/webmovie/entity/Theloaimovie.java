package com.project.webmovie.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;

import java.io.Serializable;
import  lombok.*;

@Embeddable
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class Theloaimovie implements Serializable {
        @Column(name = "movie_id")
        private int movieId;

        @Column(name = "theloai_id")
        private int theloaiId;
    }




