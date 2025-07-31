package com.project.webmovie.dto.request;

import com.project.webmovie.entity.Movie;
import com.project.webmovie.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistoryCreationRequest {
        private User user_Id;
        private Movie movie_Id;
        private LocalDateTime viewhistory;
}
