package com.project.webmovie.Repository;
import com.project.webmovie.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {
Optional<Movie> findByTieudeIgnoreCase(String tieude); //IgnoreCase: k phân biệt chữ hoa/thường
}
