package com.inyourcare.service;

import com.inyourcare.model.Patient;
import com.inyourcare.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    // Create a new patient
    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    // Get all patients
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    // Get patient by ID
    public Patient getPatientById(Long id) {
        Optional<Patient> patient = patientRepository.findById(id);
        return patient.orElse(null);  // Return null if patient not found
    }

    // Get patient by userId
    public List<Patient> getPatientByUserId(Long userId) {
        List<Patient> patients = patientRepository.findByUserId(userId);
        return patients;  // Return null if patient not found
    }

    // Update patient details
    public Patient updatePatient(Long id, Patient patient) {
        if (patientRepository.existsById(id)) {
            patient.setId(id);  // Ensure the ID is set to the correct one
            return patientRepository.save(patient);
        }
        return null;  // Return null if the patient doesn't exist
    }

    // Delete patient
    public void deletePatient(Long id) {
        if (patientRepository.existsById(id)) {
            patientRepository.deleteById(id);
        }
    }
}
