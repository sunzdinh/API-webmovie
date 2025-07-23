package com.project.webmovie.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="THELOAI")
public class Theloai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name=" ID ")
    private long id ;
    @Column(name=" NAME ")
    private String name ;
}
