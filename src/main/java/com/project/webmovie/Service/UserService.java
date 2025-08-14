package com.project.webmovie.Service;

import com.project.webmovie.Repository.UserRepository;
import com.project.webmovie.dto.request.UserCreationRequest;
import com.project.webmovie.dto.request.UserUpdateRequest;
import com.project.webmovie.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
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

        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setQuyennguoidung(request.getQuyennguoidung());
        user.setCreatedAt(request.getCreatedAt());
        return userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUser(long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User updateUser(long userId, UserUpdateRequest request) {
        User user = getUser(userId);

        if (request.getUsername() != null) {
            if (userRepository.existsByUsername(request.getUsername()) &&
                    !user.getUsername().equals(request.getUsername())) {
                throw new RuntimeException("Username already exists");
            }
            user.setUsername(request.getUsername());
        }
        if (request.getEmail() != null) {
            user.setEmail(request.getEmail());
        }
        if (request.getPassword() != null) {
            user.setPassword(passwordEncoder.encode(request.getPassword()));
        }
        if (request.getQuyennguoidung() != null) {
            user.setQuyennguoidung(request.getQuyennguoidung());
        }

        return userRepository.save(user);
    }

    public void deleteUser(long userId) {
        User user = getUser(userId);
        userRepository.delete(user);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void resetPassword(long userId, String newPassword) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
    }
    /*
    public void generatePasswordResetOtp(String email) {
        User user = (User) userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Email không tồn tại"));

        String otp = String.valueOf(new Random().nextInt(900000) + 100000);
        //user.setResetOtp(otp);
        //user.setResetOtpExpiry(LocalDateTime.now().plusMinutes(5));

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
    */
}