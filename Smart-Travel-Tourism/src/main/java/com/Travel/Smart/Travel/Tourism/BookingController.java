package com.Travel.Smart.Travel.Tourism;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingRepository repository;

    public BookingController(BookingRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Booking> getAllBookings() {
        return repository.findAll();
    }

    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        return repository.save(booking);
    }

    @PutMapping("/{id}/cancel")
    public Booking cancelBooking(@PathVariable Long id) {

        Booking booking = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        booking.setStatus("CANCELLED");

        return repository.save(booking);
    }
}