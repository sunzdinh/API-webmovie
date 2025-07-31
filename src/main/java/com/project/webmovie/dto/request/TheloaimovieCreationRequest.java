package com.project.webmovie.dto.request;

import com.project.webmovie.entity.Genre;
import com.project.webmovie.entity.Movie;
import com.project.webmovie.entity.Theloaimovie;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TheloaimovieCreationRequest {

            private Long movieId;
            private Long theloaiId;
        }
