package com.inyourcare.service;

import com.inyourcare.model.Person;
import com.inyourcare.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository userRepository;

    // Create a new user
    public Person createUser(Person user) {
        return userRepository.save(user);
    }

    // Get all users
    public List<Person> getAllUsers() {
        return userRepository.findAll();
    }

    // Get user by ID
    public Person getUserById(Long id) {
        Optional<Person> user = userRepository.findById(id);
        return user.orElse(null);  // Return null if user not found
    }

    // Update user details
    public Person updateUser(Long id, Person user) {
        if (userRepository.existsById(id)) {
            user.setId(id);  // Ensure the ID is set to the correct one
            return userRepository.save(user);
        }
        return null;  // Return null if the user doesn't exist
    }

    // Delete user
    public void deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        }
    }

    // signup user
    public ResponseEntity<?> signup(Person user) {
        Optional<Person> existingUser = userRepository.findByUsername(user.getUsername());

        if(existingUser.isPresent()){
            return ResponseEntity.status(409).body("User with this username already exists");
        }

        // Create the user if not present
        Person newUser = this.createUser(user);
        return ResponseEntity.ok(newUser);
    }

    // signup user
    public ResponseEntity<?> signin(Person user) {
        Optional<Person> existingUser = userRepository.findByEmailAndPassword(user.getPassword(), user.getEmail());

        if(existingUser.isPresent()){
            return ResponseEntity.ok(existingUser);
        }
        
        return ResponseEntity.status(409).body("User with this username doesn't exists");
    }
}
