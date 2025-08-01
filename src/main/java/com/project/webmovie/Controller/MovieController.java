package com.project.webmovie.Controller;
import com.project.webmovie.Service.MovieService;
import com.project.webmovie.dto.request.MovieCreationRequest;
import com.project.webmovie.dto.request.MovieUpdateRequest;
import com.project.webmovie.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @PostMapping
    public Movie createMoive(@RequestBody MovieCreationRequest request){
        return movieService.CreateRequest(request);
    }
    @GetMapping
    List<Movie> getMovies(){
        return  movieService.getMovies();
    }
    @GetMapping("/{movieId}")
    Movie getMovie(@PathVariable ("movieId") long movieId ){
        return movieService.getMovie(movieId);
    }
    @GetMapping("/tieude/{tieude}")
    public ResponseEntity<?> getMovieByTieude(@PathVariable String tieude){
        Movie movie=movieService.getMovieByTieude(tieude);
        return ResponseEntity.ok(movie);
    }
    @PutMapping("/{movieId}")
    Movie upateMovie(@PathVariable long movieId,@RequestBody MovieUpdateRequest request){
        return movieService.updateMovie(movieId,request);
    }
    @DeleteMapping("/{movieId}")
    public String deleteMovie(@PathVariable long movieId){
        movieService.deleteMovie(movieId);
        return "Movie has been deleted";
    }

}
