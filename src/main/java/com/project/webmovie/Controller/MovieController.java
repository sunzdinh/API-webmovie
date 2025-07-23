package com.project.webmovie.Controller;
import com.project.webmovie.Service.MovieService;
import com.project.webmovie.dto.request.MovieCreationRequest;
import com.project.webmovie.dto.request.MovieUpdateRequest;
import com.project.webmovie.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @PutMapping("/{movies}")
    Movie upateMovie(@PathVariable long movieId,@RequestBody MovieUpdateRequest request){
        return movieService.updateMovie(movieId,request);
    }
    @DeleteMapping("/{movies}")
    public String deleteMovie(@PathVariable long movieId){
        movieService.deleteMovie(movieId);
        return "Movie has been deleted";
    }

}
