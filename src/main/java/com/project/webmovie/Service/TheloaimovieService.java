package com.project.webmovie.Service;

import com.project.webmovie.Repository.TheloaimovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TheloaimovieService {
    @Autowired
    private TheloaimovieRepository theloaimovieRepository;
}
