package com.project.webmovie.Repository;


import com.project.webmovie.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GenreRepository  extends JpaRepository<Genre, Long> {
    Optional<Genre> findByNameIgnoreCase(String name);

}
