package com.inyourcare.repository;

import com.inyourcare.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {

    List<Organization> findByType(String type);
    
    List<Organization> findByCity(String city);
    
    List<Organization> findByTypeAndCity(String type, String city);
}
