package com.Travel.Smart.Travel.Tourism;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

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

    long bookedPeople =
            repository.sumBookedPeople(
                    booking.getPackageName(),
                    booking.getTravelDate(),
                    "CANCELLED"
            );

    long availableSlots = 20 - bookedPeople;

    if (availableSlots < 0) {
        availableSlots = 0;
    }

    if (booking.getNumberOfPeople() > availableSlots) {

        throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Only " + availableSlots +
                " slot(s) are available for this date"
        );
    }

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