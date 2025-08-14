package com.project.webmovie.Controller;

import com.project.webmovie.Service.MovieService;
import com.project.webmovie.dto.request.MovieCreationRequest;
import com.project.webmovie.dto.request.MovieUpdateRequest;
import com.project.webmovie.entity.Movie;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping
    public Movie createMovie(@RequestBody @Valid MovieCreationRequest request) {
        return movieService.CreateRequest(request);
    }

    @GetMapping
    public List<Movie> getMovies() {
        return movieService.getMovies();
    }

    @GetMapping("/{movieId}")
    public Movie getMovie(@PathVariable("movieId") long movieId) {
        return movieService.getMovie(movieId);
    }

    @GetMapping("/tieude/{tieude}")
    public ResponseEntity<?> getMovieByTieude(@PathVariable(name="tieude") String tieude) {
        Movie movie = movieService.getMovieByTieude(tieude);
        return ResponseEntity.ok(movie);
    }

    @PutMapping("/{movieId}")
    public Movie updateMovie(@PathVariable long movieId,
                             @RequestBody @Valid MovieUpdateRequest request) {
        return movieService.updateMovie(movieId, request);
    }

    @DeleteMapping("/{movieId}")
    public String deleteMovie(@PathVariable long movieId) {
        movieService.deleteMovie(movieId);
        return "Movie has been deleted";
    }
}