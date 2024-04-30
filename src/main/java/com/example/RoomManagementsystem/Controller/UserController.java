package com.example.RoomManagementsystem.Controller;

import com.example.RoomManagementsystem.entity.User;
import com.example.RoomManagementsystem.repository.RoomInterface;
import com.example.RoomManagementsystem.repository.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    UserInterface userInterface;
    public UserController() {


    }
    @PostMapping({"/login"})
    public ResponseEntity<?> user_login(@RequestBody Map<String, String> user) {
        try {
            String email = (String)user.get("email");
            String password = (String)user.get("password");
            Optional<User> userObj = this.userInterface.findByEmail(email);
            System.out.println(userObj);
            Map<String, String> payload = new HashMap();
            if (userObj.isEmpty()) {
                payload.put("Error", "User does not exist");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(payload);
            } else {
                User foundUser = (User)userObj.get();
                if (foundUser.getPassword().equals(password)) {
                    return ResponseEntity.status(HttpStatus.OK).body("Login Successful");
                } else {
                    payload.put("Error", "Username/Password Incorrect");
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(payload);
                }
            }
        } catch (Exception var7) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Login Api Error");
        }
    }

    @PostMapping({"/signup"})
    public ResponseEntity<?> user_signup(@RequestBody Map<String, String> user) {
        try {
            String email = (String)user.get("email");
            String name = (String)user.get("name");
            String password = (String)user.get("password");
            Optional<User> existingUser = this.userInterface.findByEmail(email);
            if (existingUser.isPresent()) {
                Map<String, String> payload = new HashMap();
                payload.put("Error", "Forbidden, Account already exists");
                return ResponseEntity.status(HttpStatus.CONFLICT).body(payload);
            } else {
                User userObj = new User();
                userObj.setEmail(email);
                userObj.setName(name);
                userObj.setPassword(password);
                System.out.println(userObj);
                User savedUser = userInterface.save(userObj);

                System.out.println(userObj);
                return ResponseEntity.status(HttpStatus.OK).body("Account Creation Successful");
            }
        } catch (Exception var8) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Sign Up Api Error");
        }
    }

    @GetMapping({"/user"})
    public ResponseEntity<?> user_details(@RequestParam(required = false) Integer userId) {
        if (userId == null) {
            List<User> allUsers = this.userInterface.findAll();
            return ResponseEntity.status(HttpStatus.OK).body(allUsers);
        } else {
            Optional<User> found_user = this.userInterface.findById(userId);
            if (found_user.isPresent()) {
                return ResponseEntity.status(HttpStatus.OK).body((User)found_user.get());
            } else {
                Map<String, String> payload = new HashMap();
                payload.put("Error", "User does not exist");
                return ResponseEntity.status(HttpStatus.CONFLICT).body(payload);
            }
        }
    }
}
