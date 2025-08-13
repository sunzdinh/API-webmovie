package com.project.webmovie.Service;

import com.project.webmovie.Config.JwtUtil;
import com.project.webmovie.Exception.ApiException;
import com.project.webmovie.Repository.UserRepository;
import com.project.webmovie.dto.request.AuthenticationRequest;
import com.project.webmovie.dto.response.AuthenticationResponse;
import com.project.webmovie.Exception.ApiException;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationService {
@Autowired
    UserRepository userRepository;
    PasswordEncoder passwordEncoder;
    JwtUtil jwtUtil;
    AuthenticationManager authenticationManager;
    CustomUserDetailsService userDetailsService;

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        // 1. Authenticate với Spring Security
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(),
                            request.getPassword()
                    )
            );
        } catch (BadCredentialsException e) {
            throw new ApiException("Invalid username or password", 401);
        }

        // 2. Load user từ database
        var user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new ApiException("User not found username"+ request.getUsername(), 404));

        // 3. Load UserDetails cho JWT
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());

        // 4. Generate JWT token
        String token = jwtUtil.generateToken(userDetails);

        // 5. Return response với token
        return AuthenticationResponse.builder()
                .token(token)
                .username(user.getUsername())
                .role(user.getQuyennguoidung().name())
                .build();
    }
}