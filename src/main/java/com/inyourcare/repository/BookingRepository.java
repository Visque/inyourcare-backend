package com.inyourcare.repository;

import com.inyourcare.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    
    // Find bookings by patient ID
    List<Booking> findByPatientId(Long patientId);

    // Find bookings by nurse's hospital (assuming you have a "nurseHospital" field in the Booking model)
    // List<Booking> findByNurse(String hospitalName);

    // List<Booking> findByHospital(String hospitalName);

    // Find bookings by caretaker organization (assuming you have a "caretakerOrganization" field)
    // List<Booking> findByOrganization(String organizationName);

    // Find bookings by status (e.g., "confirmed", "pending")
    List<Booking> findByStatus(String status);
}
