package com.project.webmovie.Repository;

import com.project.webmovie.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryRepository extends JpaRepository < History,  Long> {

}
