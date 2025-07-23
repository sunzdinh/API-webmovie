package com.project.webmovie.entity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.query.sql.internal.ParameterRecognizerImpl;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Episodes")

public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "SOTAPPHIM")
    private int sotapphim;
    @Column(name = "VIDEO_URL")
    private String video_url;
    @Column(name = "movie_id")
    private Long movieId;

}
