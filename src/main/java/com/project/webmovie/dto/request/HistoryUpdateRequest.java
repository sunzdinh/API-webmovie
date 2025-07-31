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
public class HistoryUpdateRequest {

        private User user;
        private Movie movie;
        private LocalDateTime viewhistory;
}
