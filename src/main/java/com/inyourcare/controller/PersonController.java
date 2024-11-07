package com.inyourcare.controller;

import com.inyourcare.model.Person;
import com.inyourcare.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
    
@RestController
@RequestMapping("users")
@CrossOrigin(origins = "http://localhost:5173")
public class PersonController {

    @Autowired
    private PersonService userService;

    // Create a new user
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody Person user) {
        return userService.signup(user);
    }

    // Create a new user
    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestBody Person user) {
        return userService.signin(user);
    }

    // Get all users
    @GetMapping("all")
    public ResponseEntity<List<Person>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    // Get user by ID
    @GetMapping("/{id}")
    public ResponseEntity<Person> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    // Update user details
    @PutMapping("/update/{id}")
    public ResponseEntity<Person> updateUser(@PathVariable Long id, @RequestBody Person user) {
        return ResponseEntity.ok(userService.updateUser(id, user));
    }

    // Delete user
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
