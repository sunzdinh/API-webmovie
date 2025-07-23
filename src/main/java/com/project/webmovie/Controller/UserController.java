package com.project.webmovie.Controller;
import com.project.webmovie.Service.UserService;
import com.project.webmovie.dto.request.UserCreationRequest;
import com.project.webmovie.dto.request.UserUpdateRequest;
import com.project.webmovie.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")

public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public User creatUser(@RequestBody UserCreationRequest request){

        return  userService.createRequest(request);
    }
    //Get ca list luon
    @GetMapping
    List<User> getUsers(){
        return userService.getUsers();
    }
    //Get kiem theo id
    @GetMapping("/{userId}")
    User getUser(@PathVariable("userId") long userId){
        return userService.getUser(userId);
    }
    //Update Users id
    @PutMapping("/{userId}")
    User updateUser(@PathVariable long userId, @RequestBody UserUpdateRequest request){
        return userService.updateUser(userId,request);
    }
    //Delete Users id
    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable long userId){
        userService.deleteUser(userId);
        return "User has been deleted";
    }

}
