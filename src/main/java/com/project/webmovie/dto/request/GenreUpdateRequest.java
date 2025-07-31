package com.project.webmovie.dto.request;

import com.project.webmovie.entity.Theloaimovie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GenreUpdateRequest {
        private String name ;
        private Set<Theloaimovie> theloaimovie;

    }
