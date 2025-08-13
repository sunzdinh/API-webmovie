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

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public User createRequest(UserCreationRequest request) {
        if(userRepository.existsByUsername((request.getUsername())))
            throw new RuntimeException("User existed ");
        if(userRepository.existsByEmail(request.getEmail()))
            throw new RuntimeException("Email existed");

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        boolean isAuthenticated = auth != null && auth.isAuthenticated() && !"anonymousUser".equals(auth.getPrincipal());
        boolean isAdmin = isAuthenticated && auth.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));

        if ("admin".equalsIgnoreCase(request.getQuyennguoidung().name()) && !isAdmin) {
            throw new RuntimeException("Only admin can create admin account");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
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
        if (request.getUsername() != null) {
            if (userRepository.existsByUsername(request.getUsername()) &&
                    !user.getUsername().equals(request.getUsername())) {
                throw new RuntimeException("Username already exists");
            }
            user.setUsername(request.getUsername());
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

    public void resetPassword(long userId, String newPassword) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
    }

    public void generatePasswordResetOtp(String email) {
        User user = (User) userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Email không tồn tại"));

        String otp = String.valueOf(new Random().nextInt(900000) + 100000);
        user.setResetOtp(otp);
        user.setResetOtpExpiry(LocalDateTime.now().plusMinutes(5));

        userRepository.save(user);

        // TODO: Gửi email
        System.out.println("OTP cho " + email + ": " + otp);
    }

    public void resetPasswordWithOtp(String email, String otp, String newPassword) {
        User user = (User) userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Email không tồn tại"));

        if (user.getResetOtp() == null || !user.getResetOtp().equals(otp))
            throw new RuntimeException("OTP không hợp lệ");

        if (user.getResetOtpExpiry().isBefore(LocalDateTime.now()))
            throw new RuntimeException("OTP đã hết hạn");

        user.setPassword(passwordEncoder.encode(newPassword));
        user.setResetOtp(null);
        user.setResetOtpExpiry(null);

        userRepository.save(user);
    }
}