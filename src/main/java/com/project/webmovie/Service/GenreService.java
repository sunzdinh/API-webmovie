package com.project.webmovie.Service;

import com.project.webmovie.Repository.GenreRepository;
import com.project.webmovie.dto.request.GenreCreationRequest;
import com.project.webmovie.entity.Genre;
import com.project.webmovie.entity.History;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class GenreService {
    @Autowired
    private GenreRepository genreRepository;
    public Genre createRequest  (GenreCreationRequest request){
        Genre genre = new Genre();
        genre.setName(request.getName());
        genre.setTheloaimovie(request.getTheloaimovie());
        return genreRepository.save(genre);
    }

    public  Genre updateGenre ( long genreId, GenreCreationRequest request){
        Genre genre = getGenre(genreId);
        genre.setName(request.getName());
        genre.setTheloaimovie(request.getTheloaimovie());
        return  genreRepository.save(genre);
    }

    public List<Genre> getGenres(){
        return genreRepository.findAll();
    }

    public  Genre getGenre(long id){
        return  genreRepository.findById(id).orElseThrow(()-> new RuntimeException("No Found"));
    }
    public  void deleteGenre( long genreId){
        genreRepository.deleteById(genreId);
    }



}
