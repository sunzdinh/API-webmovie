package com.project.webmovie.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EpisodeUpdateRequest {
    private int sotapphim;
    private String video_url;
    private Long movieId;

}
