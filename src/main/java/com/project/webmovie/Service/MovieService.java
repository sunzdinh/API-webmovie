package com.project.webmovie.Service;

import com.project.webmovie.Repository.MovieRepository;
import com.project.webmovie.dto.request.MovieCreationRequest;
import com.project.webmovie.dto.request.MovieUpdateRequest;
import com.project.webmovie.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service

public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
    public Movie CreateRequest(MovieCreationRequest request){
        Movie movie =new Movie();
        movie.setTieude(request.getTieude());
        movie.setMota(request.getMota());
        movie.setNamphathanh(request.getNamphathanh());
        movie.setThoiluong(request.getThoiluong());
        movie.setDuongdan_url(request.getDuongdan_url());
        movie.setTrailer_url(request.getTrailer_url());
        movie.setCreated_at(request.getCreata_at());
        return movieRepository.save(movie);
    }
    public List<Movie> getMovies(){
        return movieRepository.findAll();
    }
    public  Movie getMovie(long id){
        return movieRepository.findById(id)
                .orElseThrow(
                        () ->new RuntimeException("Movie not found"));
    }
    public Movie updateMovie(long movieId, MovieUpdateRequest request){
        Movie movie=getMovie(movieId);
        movie.setTieude(request.getTieude());
        movie.setMota(request.getMota());
        movie.setNamphathanh(request.getNamphathanh());
        movie.setThoiluong(request.getThoiluong());
        movie.setDuongdan_url(request.getDuongdan_url());
        movie.setTrailer_url(request.getTrailer_url());
        movie.setCreated_at(request.getCreata_at());
        return movieRepository.save(movie);
    }
    public void deleteMovie(long movieId){
        movieRepository.deleteById(movieId);
    }
}
