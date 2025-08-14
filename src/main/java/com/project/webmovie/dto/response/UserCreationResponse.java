package com.project.webmovie.dto.response;
import com.project.webmovie.entity.User;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCreationResponse {
    String username;
    String email;
    String password;
    User.Accountrole quyennguoidung;
    private LocalDateTime createdAt = LocalDateTime.now();
}