package com.project.webmovie.dto.response;

import com.project.webmovie.entity.Movie;
import com.project.webmovie.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HistoryUpdateResponse {

        private User user;
        private Movie movie;
        private LocalDateTime viewhistory;
}
