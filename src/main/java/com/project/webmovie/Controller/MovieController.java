package com.project.webmovie.Controller;

import com.project.webmovie.Service.MovieService;
import com.project.webmovie.dto.request.MovieCreationRequest;
import com.project.webmovie.dto.request.MovieUpdateRequest;
import com.project.webmovie.entity.Movie;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    // Tạo phim mới - Chỉ admin
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Movie createMovie(@RequestBody @Valid MovieCreationRequest request) {
        return movieService.CreateRequest(request);
    }

    // Xem danh sách phim - Ai cũng có thể xem (không cần đăng nhập)
    @GetMapping
    public List<Movie> getMovies() {
        return movieService.getMovies();
    }

    // Xem chi tiết 1 phim - Ai cũng có thể xem
    @GetMapping("/{movieId}")
    public Movie getMovie(@PathVariable("movieId") long movieId) {
        return movieService.getMovie(movieId);
    }

    // Tìm phim theo tiêu đề - Ai cũng có thể tìm
    @GetMapping("/tieude/{tieude}")
    public ResponseEntity<?> getMovieByTieude(@PathVariable String tieude) {
        Movie movie = movieService.getMovieByTieude(tieude);
        return ResponseEntity.ok(movie);
    }

    // Cập nhật phim - Chỉ admin
    @PutMapping("/{movieId}")
    @PreAuthorize("hasRole('ADMIN')")
    public Movie updateMovie(@PathVariable long movieId,
                             @RequestBody @Valid MovieUpdateRequest request) {
        return movieService.updateMovie(movieId, request);
    }

    // Xóa phim - Chỉ admin
    @DeleteMapping("/{movieId}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteMovie(@PathVariable long movieId) {
        movieService.deleteMovie(movieId);
        return "Movie has been deleted";
    }


}