package com.project.webmovie.Service;

import com.project.webmovie.Repository.UserRepository;
import com.project.webmovie.dto.request.UserCreationRequest;
import com.project.webmovie.dto.request.UserUpdateRequest;
import com.project.webmovie.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public User createRequest(UserCreationRequest request) {
        User user = new User();

        if(userRepository.existsByUsername((request.getUsername())))
            throw new RuntimeException("User existed ");
        if(userRepository.existsByEmail(request.getEmail()))
            throw new RuntimeException("Email existed");

        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setQuyennguoidung(request.getQuyennguoidung());
        user.setCreatedAt(request.getCreatedAt());
        return userRepository.save(user);
    }
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    // Lấy user theo ID - Admin hoặc của chính user đó
    @PreAuthorize("hasRole('ADMIN') or @userService.isCurrentUser(#userId)")
    public User getUser(long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    // Cập nhật user - Admin hoặc chính user đó
    @PreAuthorize("hasRole('ADMIN') or @userService.isCurrentUser(#userId)")
    public User updateUser(long userId, UserUpdateRequest request) {
        User user = getUser(userId);

        // Chỉ admin mới thay role
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        boolean isAdmin = auth.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));

        if (request.getUsername() != null) {
            user.setUsername(request.getUsername());
        }
        if (request.getEmail() != null) {
            user.setEmail(request.getEmail());
        }
        if (request.getPassword() != null) {
            user.setPassword(passwordEncoder.encode(request.getPassword()));
        }

        // Chỉ admin mới được thay đổi quyền
        if (request.getQuyennguoidung() != null && isAdmin) {
            user.setQuyennguoidung(request.getQuyennguoidung());
        }

        return userRepository.save(user);
    }

    // Xóa user - Chỉ admin
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteUser(long userId) {
        User user = getUser(userId);
        userRepository.delete(user);
    }

    // Lấy user theo username
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    // Helper method kiểm tra user hiện tại
    public boolean isCurrentUser(long userId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || auth.getName() == null) {
            return false;
        }

        try {
            User currentUser = getUserByUsername(auth.getName());
            return currentUser.getId() == userId;
        } catch (Exception e) {
            return false;
        }
    }
}