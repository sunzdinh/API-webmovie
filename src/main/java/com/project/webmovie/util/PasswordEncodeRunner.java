package com.project.webmovie.util;

import com.project.webmovie.Repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncodeRunner implements CommandLineRunner {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public PasswordEncodeRunner(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public void run(String... args) {
        System.out.println("=== Starting password encoding process ===");

        userRepository.findAll().forEach(user -> {
            String currentPassword = user.getPassword();

            // Nếu password chưa encode (không bắt đầu bằng "$2a$" hoặc "$2b$")
            if (!currentPassword.startsWith("$2a$") && !currentPassword.startsWith("$2b$")) {
                String encoded = passwordEncoder.encode(currentPassword);
                user.setPassword(encoded);
                userRepository.save(user);
                System.out.println("Encoded password for user: " + user.getUsername());
            } else {
                System.out.println("Already encoded: " + user.getUsername());
            }
        });

        System.out.println("=== Password encoding process completed ===");
    }
}
