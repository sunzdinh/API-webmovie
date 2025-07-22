package com.project.webmovie.entity;


import jakarta.persistence.*;
import lombok.*;


import javax.management.relation.Role;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USERS")
public class User {
    public enum Accountrole {
        user, admin
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PASSWORD")
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(name = "QUYENNGUOIDUNG", columnDefinition = "ENUM(' user ',' admin ') DEFAULT ' user '")
    private Accountrole quyennguoidung = Accountrole.user;
    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt = LocalDateTime.now();

}