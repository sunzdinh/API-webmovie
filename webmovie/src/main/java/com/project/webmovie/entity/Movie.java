package com.project.webmovie.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "MOVIE")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;
    @Column(name = "TIEUDE")
    private String tieude;
    @Column(name = "MOTA")
    private String mota;
    @Column(name = "NAMPHATHANH")
    private int namphathanh;
    @Column(name = "THOILUONG")
    private int thoiluong;
    @Column(name = "DUONGDAN")
    private String duongdan_url;
    @Column(name = "TRAILER_URL")
    private String trailer_url;
    @Column(name = "CREATED_AT", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime created_at;

}