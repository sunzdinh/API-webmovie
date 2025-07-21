package com.project.webmovie.entity;

import jakarta.persistence.*;

@Entity
@Table(name="THELOAI")
public class Theloai {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name=" ID ")
    private int id ;
    @Column(name=" NAME ")
    private String name ;
}
