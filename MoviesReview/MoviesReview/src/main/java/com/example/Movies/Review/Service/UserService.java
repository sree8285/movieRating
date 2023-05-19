package com.example.Movies.Review.Service;

import com.example.Movies.Review.Dto.RatingDto;
import com.example.Movies.Review.Repository.UsersRepository;

import com.example.Movies.Review.entities.Users;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UsersRepository usersRepository;

    public ResponseEntity<Users> addUser(Users user) {
        try {
            log.info(user.toString());
            return new ResponseEntity<>(usersRepository.save(user), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("error occured" + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Users> updateUser(int userId, RatingDto ratingDto) {
        try {
            Users existUser = usersRepository.findById(userId).orElseThrow();
            if (ratingDto.getPhNumber() != 0) {
                existUser.setPhNumber(ratingDto.getPhNumber());
            }
            if (ratingDto.getEmail() != null) {
                existUser.setEmail(ratingDto.getEmail());
            }
            return new ResponseEntity<>(usersRepository.save(existUser), HttpStatus.OK);
        } catch (NoSuchElementException ex) {
            log.warn("user not found " + userId);
            return new ResponseEntity("user not found with this id " + userId, HttpStatus.NOT_FOUND);
        } catch (Throwable e) {
            e.printStackTrace();
            log.error("error occured " + e.getMessage());
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Void> deleteUserById(int userId) {
        try {
            Optional<Users> users=usersRepository.findById(userId);
            if (users.isPresent()) {
                log.info("user exists");
                usersRepository.deleteById(userId);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }else{
                log.warn("no user exists with this id " + userId);
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            log.warn("no user exists with this id " + userId);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
