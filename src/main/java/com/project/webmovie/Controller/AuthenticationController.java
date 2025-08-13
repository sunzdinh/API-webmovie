package com.project.webmovie.Controller;

import com.project.webmovie.Service.AuthenticationService;
import com.project.webmovie.dto.request.AuthenticationRequest;
import com.project.webmovie.dto.response.AuthenticationResponse;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {

    AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody @Valid AuthenticationRequest request) {

        log.info("Authentication request for username: {}", request.getUsername());

        AuthenticationResponse response = authenticationService.authenticate(request);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/validate")
    public ResponseEntity<String> validateToken(
            @RequestHeader("Authorization") String token) {

        // Simple endpoint to validate if token is still valid
        // If request reaches here, token is valid (thanks to JWT filter)
        return ResponseEntity.ok("Token is valid");
    }
}