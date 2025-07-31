package com.project.webmovie.Repository;

import com.project.webmovie.entity.Theloaimovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheloaimovieRepository extends JpaRepository<Theloaimovie, Long> {

}
