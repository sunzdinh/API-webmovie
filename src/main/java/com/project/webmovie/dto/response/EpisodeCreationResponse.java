package com.project.webmovie.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EpisodeCreationResponse {
    private int sotapphim;
    private String video_url;
    private Long movieId;
}
