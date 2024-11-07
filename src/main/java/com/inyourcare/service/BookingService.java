package com.inyourcare.service;

import com.inyourcare.model.Booking;
// import com.inyourcare.model.Organization;
import com.inyourcare.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;
    // private OrganizationService organizationService;

    // Create a new booking
    public Booking createBooking(Booking booking) {
        // Long orgId = booking.getOrganizationId();
        // Optional<Organization> organization = organizationService.findById(orgId);

        return bookingRepository.save(booking);
    }

    // Get all bookings
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    // Get booking by ID
    public Booking getBookingById(Long id) {
        Optional<Booking> booking = bookingRepository.findById(id);
        return booking.orElse(null);  // Return null if booking not found
    }

    // Update booking details
    public Booking updateBooking(Long id, Booking booking) {
        if (bookingRepository.existsById(id)) {
            booking.setId(id);  // Ensure the ID is set to the correct one
            return bookingRepository.save(booking);
        }
        return null;  // Return null if the booking doesn't exist
    }

    // Delete booking
    public void deleteBooking(Long id) {
        if (bookingRepository.existsById(id)) {
            bookingRepository.deleteById(id);
        }
    }
}
