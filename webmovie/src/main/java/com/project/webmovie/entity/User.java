package com.project.webmovie.entity;

import jakarta.persistence.*;


import javax.management.relation.Role;
import java.time.LocalDateTime;

@Entity

@Table(name = "USER")
public class User {
    public enum Accountrole{
        user, admin
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column (name ="ID")
   private int id;
    @Column (name ="USERNAME")
   private String  username;
    @Column (name ="EMAIL")
   private  String email;
    @Column (name ="PASSWORD")
   private String password;
    @Enumerated(EnumType.STRING)
    @Column (name ="QUYENNGUOIDUNG",columnDefinition = "ENUM(' user ',' admin ') DEFAULT ' user '")
   private Accountrole quyennguoidung =Accountrole.user;
    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt = LocalDateTime.now();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Role getQuyennguoidung() {
        return quyennguoidung;
    }

    public void setQuyennguoidung(Role quyennguoidung) {
        this.quyennguoidung = quyennguoidung;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
