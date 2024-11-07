package com.inyourcare.service;

import com.inyourcare.model.Organization;
import com.inyourcare.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;

    public List<Organization> getAllOrganizations() {
        return organizationRepository.findAll();
    }

    public Optional<Organization> findById(Long id) {
        return organizationRepository.findById(id);
    }

    public List<Organization> getOrganizationsByType(String type) {
        return organizationRepository.findByType(type);
    }

    public List<Organization> getOrganizationsByCity(String city) {
        return organizationRepository.findByCity(city);
    }

    public List<Organization> getOrganizationsByTypeAndCity(String type, String city) {
        return organizationRepository.findByTypeAndCity(type, city);
    }

    public Organization createOrganization(Organization organization) {
        return organizationRepository.save(organization);
    }

    public List<Organization> createMultipleOrganization(List<Organization> organizations) {
        return organizationRepository.saveAll(organizations);
    }

    public List<Organization> getOrganizationsByFilters(String city, String type) {
        if (city != null && type != null) {
            return organizationRepository.findByTypeAndCity(type, city);
        } else if (city != null) {
            return organizationRepository.findByCity(city);
        } else if (type != null) {
            return organizationRepository.findByType(type);
        } else {
            return organizationRepository.findAll();
        }
    }
}
