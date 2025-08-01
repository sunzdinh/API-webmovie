package com.project.webmovie.Service;

import com.project.webmovie.Repository.UserRepository;
import com.project.webmovie.dto.request.UserCreationRequest;
import com.project.webmovie.dto.request.UserUpdateRequest;
import com.project.webmovie.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

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

    //Post Users
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    //Get Users
    public User getUser(long id) {
        return userRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("User not found"));
    }

    //Update Users
    public User updateUser(long userId, UserUpdateRequest request) {
        User user = getUser(userId);
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setQuyennguoidung(request.getQuyennguoidung());
        user.setCreatedAt(request.getCreatedAt());
        return userRepository.save(user);
    }

    public void deleteUser(long userId) {
        userRepository.deleteById(userId);
    }

}