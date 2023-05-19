package com.example.Movies.Review.Controller;

import com.example.Movies.Review.Dto.RatingDto;
import com.example.Movies.Review.Service.MovieService;
import com.example.Movies.Review.Service.UserService;
import com.example.Movies.Review.entities.Rating;
import com.example.Movies.Review.entities.Users;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/add-user")
    public ResponseEntity<Users> addUser(@RequestBody Users user) {
        return userService.addUser(user);
    }

    @PutMapping("/update-user/{userId}")
    public ResponseEntity<Users> updateUser(@PathVariable("userId") int userId, @RequestBody RatingDto ratingDto) {
        return userService.updateUser(userId, ratingDto);
    }
    @DeleteMapping("/delete-user/{userId}")
    public ResponseEntity<Void> deleteUserById(@PathVariable("userId") int userId){
        return userService.deleteUserById(userId);
    }
}
