package com.project.webmovie.Controller;

import com.project.webmovie.Service.EpisodeService;
import com.project.webmovie.dto.request.EpisodeCreationRequest;
import com.project.webmovie.dto.request.EpisodeUpdateRequest;
import com.project.webmovie.entity.Episode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/episodes")
public class EpisodeController {
    @Autowired
    private EpisodeService episodeService;
    @PostMapping
    Episode createEpisode(@RequestBody EpisodeCreationRequest request){
       return episodeService.createRequest(request);
    }
    @GetMapping
    List<Episode> getEpisodes(){return episodeService.getEpisodes();}

    @GetMapping("/{episodeId}")
    Episode getEpisode(@PathVariable ("episodeId") long episodeId ) {
        return  episodeService.getEpisode(episodeId);
    }


    @PutMapping("/{episodeId}")
    Episode updateEpisode(@PathVariable long episodeId,  @RequestBody EpisodeUpdateRequest request){
        return episodeService.updateEpisode(episodeId, request);
    }
    @DeleteMapping("/{episodeId}")
    String deleteEpisode(@PathVariable long episodeId) {
           episodeService.deleteEpisode(episodeId);
           return "This episode has been removed";
    }


}
