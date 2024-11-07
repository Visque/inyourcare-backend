package com.inyourcare.repository;

import com.inyourcare.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    
    // Find a user by username (assuming you have a "username" field)
    Optional<Person> findByUsername(String username);

    // Find all users by role (if you have a role field)
    // List<Person> findByRole(String role);

    // Check if a user exists by email (if you have an email field)
    // boolean existsByEmail(String email);

    // Custom query using JPQL (to find a user by username and email)
    @Query("SELECT u FROM user u WHERE u.password = :password AND u.email = :email")
    Optional<Person> findByEmailAndPassword(@Param("password") String password, @Param("email") String email);
    
}
