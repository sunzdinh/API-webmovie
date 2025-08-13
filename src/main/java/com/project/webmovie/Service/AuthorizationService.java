package com.project.webmovie.Service;

import com.project.webmovie.Repository.UserRepository;
import com.project.webmovie.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {
    @Autowired
   private UserRepository userRepository;

    public boolean canAccessUser(String currentUsername, Long targetUserId, String currentRole) {
            if ("admin".equals(currentRole)) return true;


              User targetUser = userRepository.findById(targetUserId).orElse(null);
            return targetUser != null && targetUser.getUsername().equals(currentUsername);
    }

    public boolean canDeleteUser(String currentRole) {
            return "admin".equals(currentRole);
        }
}
