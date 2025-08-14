package com.project.webmovie.Controller;

import com.project.webmovie.Service.UserService;
import com.project.webmovie.dto.request.UserCreationRequest;
import com.project.webmovie.dto.request.UserUpdateRequest;
import com.project.webmovie.entity.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User creatUser(@RequestBody @Valid UserCreationRequest request){
        return userService.createRequest(request);
    }

    @GetMapping
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable("userId") long userId){
        return userService.getUser(userId);
    }

    @PutMapping("/{userId}")
    public User updateUser(@PathVariable long userId, @RequestBody UserUpdateRequest request){
        return userService.updateUser(userId, request);
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable long userId){
        userService.deleteUser(userId);
        return "User has been deleted";
    }

    @GetMapping("/username/{username}")
    public User getUserByUsername(@PathVariable String username){
        return userService.getUserByUsername(username);
    }

    @PutMapping("/{userId}/reset-password")
    public ResponseEntity<String> resetPassword(
            @PathVariable long userId,
            @RequestBody Map<String, String> requestBody) {

        String newPassword = requestBody.get("newPassword");
        userService.resetPassword(userId, newPassword);
        return ResponseEntity.ok("Password updated successfully");
    }
    /*
    @PostMapping("/password-reset/request")
    public ResponseEntity<String> requestPasswordReset(@RequestBody Map<String, String> body) {
        userService.generatePasswordResetOtp(body.get("email"));
        return ResponseEntity.ok("OTP đã được gửi tới email");
    }

    @PostMapping("/password-reset/confirm")
    public ResponseEntity<String> confirmPasswordReset(@RequestBody Map<String, String> body) {
        userService.resetPasswordWithOtp(
                body.get("email"),
                body.get("otp"),
                body.get("newPassword")
        );
        return ResponseEntity.ok("Đổi mật khẩu thành công");
    }
    */
}