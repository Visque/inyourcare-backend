package com.inyourcare.controller;

import com.inyourcare.model.Organization;
import com.inyourcare.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("organizations")
@CrossOrigin(origins = "http://localhost:5173")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    // Create a new organization
    @PostMapping("/create")
    public ResponseEntity<Organization> createOrganization(@RequestBody Organization organization) {
        return ResponseEntity.ok(organizationService.createOrganization(organization));
    }

    // Create multiple organizations
    @PostMapping("/create-multi")
    public ResponseEntity<List<Organization>> createMultipleOrganizations(List<Organization> organizations) {
        // You can use a for-each loop or Java streams
        return ResponseEntity.ok(organizationService.createMultipleOrganization(organizations));
    }

    // Get all organizations
    @GetMapping()
    public ResponseEntity<List<Organization>> getAllOrganizations(
        @RequestParam(required = false) String city,
        @RequestParam(required = false) String type
    ) {
        return ResponseEntity.ok(organizationService.getOrganizationsByFilters(city, type));
    }

    // Get organizations by type (e.g., "hospital" or "organization")
    @GetMapping("/type/{type}")
    public ResponseEntity<List<Organization>> getOrganizationsByType(@PathVariable String type) {
        return ResponseEntity.ok(organizationService.getOrganizationsByType(type));
    }

    // Get organizations by city
    @GetMapping("/city/{city}")
    public ResponseEntity<List<Organization>> getOrganizationsByCity(@PathVariable String city) {
        return ResponseEntity.ok(organizationService.getOrganizationsByCity(city));
    }

    // Get organizations by type and city
    @GetMapping("/type/{type}/city/{city}")
    public ResponseEntity<List<Organization>> getOrganizationsByTypeAndCity(
            @PathVariable String type,
            @PathVariable String city
    ) {
        return ResponseEntity.ok(organizationService.getOrganizationsByTypeAndCity(type, city));
    }
}
