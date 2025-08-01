package com.project.webmovie.Controller;

import com.project.webmovie.Service.GenreService;
import com.project.webmovie.dto.request.GenreCreationRequest;
import com.project.webmovie.entity.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Genres")
public class GenreController {
    @Autowired
    private GenreService genreService;
    @PostMapping
    public Genre createGenre(@RequestBody GenreCreationRequest request){
        return genreService.createRequest(request);
    }
    @GetMapping
    List<Genre > getGenre(){return genreService.getGenres(); }

    @GetMapping("/{genreId}")
    public Genre getGenre(@PathVariable("genreId")  long genreId){
        return genreService.getGenre(genreId);
    }
    @GetMapping("/name/{name}")
    public ResponseEntity<?> getGenreByName(@PathVariable String name){
        Genre genre = genreService.getGenreByName(name);
        return ResponseEntity.ok(genre);
    }
    @PutMapping("/{genreId}")
    public  Genre updateGenre(@PathVariable long genreId, @RequestBody GenreCreationRequest request){
        return genreService.updateGenre(genreId, request);
    }
    @DeleteMapping("/{genreId}")
    String deleteGenre (@PathVariable long genreId){
        genreService.deleteGenre(genreId);
        return "This Genre has been removed";
    }
}
