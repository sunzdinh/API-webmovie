package com.project.webmovie.Controller;

import com.project.webmovie.Service.UserService;
import com.project.webmovie.dto.request.UserCreationRequest;
import com.project.webmovie.dto.request.UserUpdateRequest;
import com.project.webmovie.entity.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> getUsers(){
        return userService.getUsers();
    }


    @GetMapping("/{userId}")
    @PreAuthorize("hasRole('ADMIN') or authentication.name == #userId.toString()")
    public User getUser(@PathVariable("userId") long userId){
        return userService.getUser(userId);
    }


    @PutMapping("/{userId}")
    @PreAuthorize("hasRole('ADMIN') or authentication.name == #userId.toString()")
    public User updateUser(@PathVariable long userId, @RequestBody UserUpdateRequest request){
        return userService.updateUser(userId, request);
    }


    @DeleteMapping("/{userId}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteUser(@PathVariable long userId){
        userService.deleteUser(userId);
        return "User has been deleted";
    }

    @GetMapping("/me")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public User getCurrentUser(Authentication authentication){
        String username = authentication.getName();
        return userService.getUserByUsername(username);
    }
}