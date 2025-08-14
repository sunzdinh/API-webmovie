package com.project.webmovie.dto.response;
import com.project.webmovie.entity.User;

import java.time.LocalDateTime;

public class UserUpdateRespone {
    String username;
    String email;
    String password;
    User.Accountrole quyennguoidung;
    private LocalDateTime createdAt=LocalDateTime.now();

    public UserUpdateRespone(){
        this.createdAt=LocalDateTime.now();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User.Accountrole getQuyennguoidung() {
        return quyennguoidung;
    }

    public void setQuyennguoidung(User.Accountrole quyennguoidung) {
        this.quyennguoidung = quyennguoidung;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

}
