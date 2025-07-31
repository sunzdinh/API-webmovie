package com.project.webmovie.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

    @Entity
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Table(name="Histories")
    public class History {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column( name ="id")
        private Long id;

        @ManyToOne
        @JoinColumn(name = "users_id")
        private User user_Id;

        @ManyToOne
        @JoinColumn(name = "movie_id")
        private Movie movie_Id;

        @Column(name = "viewhistory")
        private LocalDateTime viewhistory;
    }

