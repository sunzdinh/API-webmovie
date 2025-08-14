package com.project.webmovie.dto.response;

import com.project.webmovie.entity.Movie;
import com.project.webmovie.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistoryCreationResponse {
        private User user_Id;
        private Movie movie_Id;
        private LocalDateTime viewhistory;

        public User getUser_Id() {
                return user_Id;
        }

        public void setUser_Id(User user_Id) {
                this.user_Id = user_Id;
        }

        public Movie getMovie_Id() {
                return movie_Id;
        }

        public void setMovie_Id(Movie movie_Id) {
                this.movie_Id = movie_Id;
        }

        public LocalDateTime getViewhistory() {
                return viewhistory;
        }

        public void setViewhistory(LocalDateTime viewhistory) {
                this.viewhistory = viewhistory;
        }
}
