package com.project.webmovie.Service;


import com.project.webmovie.Repository.EpisodeRepository;
import com.project.webmovie.Repository.MovieRepository;
import com.project.webmovie.dto.request.EpisodeCreationRequest;
import com.project.webmovie.dto.request.EpisodeUpdateRequest;
import com.project.webmovie.entity.Episode;
import com.project.webmovie.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.project.webmovie.Repository.EpisodeRepository.*;

@Service
public class EpisodeService {
    @Autowired
    private  EpisodeRepository episodeRepository;
    @Autowired
    private MovieRepository movieRepository;

    public Episode createRequest(EpisodeCreationRequest request) {
        Movie movie = movieRepository.findById(request.getMovieId())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy movieId: " + request.getMovieId()));

        Episode episode = new Episode();
        episode.setSotapphim(request.getSotapphim());
        episode.setVideo_url(request.getVideo_url());
        episode.setMovie(movie); // gán entity Movie

        return episodeRepository.save(episode);
    }

    public Episode updateEpisode(long episodeId, EpisodeUpdateRequest request) {
        Episode episode = getEpisode(episodeId);
            episode.setSotapphim(request.getSotapphim());
            episode.setVideo_url(request.getVideo_url());
            Movie movie = movieRepository.findById(request.getMovieId())
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy movieId: " + request.getMovieId()));
            episode.setMovie(movie);
        return episodeRepository.save(episode);
    }
    public  void deleteEpisode(long episodeId){
        episodeRepository.deleteById(episodeId);
    }


    public List<Episode> getEpisodes(){
        return episodeRepository.findAll();
    }
    public Episode getEpisode( long id){
        return episodeRepository.findById(id).orElseThrow(() -> new RuntimeException("Episode not found"));
    }

}
