package com.project.webmovie.Controller;

import com.project.webmovie.Service.TheloaimovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TheloaimovieController {
    @Autowired
    private TheloaimovieService theloaimovieService;
}
