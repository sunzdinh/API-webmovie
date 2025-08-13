package com.project.webmovie.Service;

import com.project.webmovie.Repository.MovieRepository;
import com.project.webmovie.dto.request.MovieCreationRequest;
import com.project.webmovie.dto.request.MovieUpdateRequest;
import com.project.webmovie.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    // Tạo phim mới - Chỉ admin
    @PreAuthorize("hasRole('ADMIN')")
    public Movie CreateRequest(MovieCreationRequest request) {
        Movie movie = new Movie();

        movie.setTieude(request.getTieude());
        movie.setMota(request.getMota());
        movie.setNamphathanh(request.getNamphathanh());
        movie.setThoiluong(request.getThoiluong());
        movie.setDuongdan_url(request.getDuongdan_url());
        movie.setTrailer_url(request.getTrailer_url());

        // Tự động set thời gian tạo hiện tại
        movie.setCreated_at(LocalDateTime.now());

        // Log admin đã tạo phim
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("Admin " + auth.getName() + " đã tạo phim: " + movie.getTieude());

        return movieRepository.save(movie);
    }

    // Lấy tất cả phim - Public
    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    // Lấy 1 phim - Public
    public Movie getMovie(long id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found"));
    }

    // Tìm phim theo tiêu đề - Public
    public Movie getMovieByTieude(String tieude) {
        return movieRepository.findByTieudeIgnoreCase(tieude)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy phim với tiêu đề: " + tieude));
    }

    // Cập nhật phim - Chỉ admin
    @PreAuthorize("hasRole('ADMIN')")
    public Movie updateMovie(long movieId, MovieUpdateRequest request) {
        Movie movie = getMovie(movieId);

        // Chỉ cập nhật những field không null
        if (request.getTieude() != null) {
            movie.setTieude(request.getTieude());
        }
        if (request.getMota() != null) {
            movie.setMota(request.getMota());
        }
        if (request.getNamphathanh() != null) {
            movie.setNamphathanh(request.getNamphathanh());
        }
        if (request.getThoiluong() != null) {
            movie.setThoiluong(request.getThoiluong());
        }
        if (request.getDuongdan_url() != null) {
            movie.setDuongdan_url(request.getDuongdan_url());
        }
        if (request.getTrailer_url() != null) {
            movie.setTrailer_url(request.getTrailer_url());
        }

        // Log admin đã cập nhật
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("Admin " + auth.getName() + " đã cập nhật phim: " + movie.getTieude());

        return movieRepository.save(movie);
    }

    // Xóa phim - Chỉ admin
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteMovie(long movieId) {
        Movie movie = getMovie(movieId);

        // Log admin đã xóa
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("Admin " + auth.getName() + " đã xóa phim: " + movie.getTieude());

        movieRepository.deleteById(movieId);
    }


}