package com.Travel.Smart.Travel.Tourism;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/packages")
public class TourPackageController {

    private final TourPackageRepository repository;
    private final BookingRepository bookingRepository;

    public TourPackageController(
            TourPackageRepository repository,
            BookingRepository bookingRepository) {

        this.repository = repository;
        this.bookingRepository = bookingRepository;
    }

    @GetMapping
    public List<TourPackage> getAllPackages() {
        return repository.findAll();
    }
    
    @GetMapping("/{id}")
public TourPackage getPackageById(@PathVariable Long id) {
    return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Package not found"));
    }

    @PostMapping
    public TourPackage addPackage(@RequestBody TourPackage tourPackage) {
        return repository.save(tourPackage);
    }

    @PutMapping("/{id}")
    public TourPackage updatePackage(
            @PathVariable Long id,
            @RequestBody TourPackage tourPackage) {

        TourPackage existingPackage = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Package not found"));

        existingPackage.setPackageName(tourPackage.getPackageName());
        existingPackage.setDestination(tourPackage.getDestination());
        existingPackage.setDuration(tourPackage.getDuration());
        existingPackage.setPrice(tourPackage.getPrice());
        existingPackage.setDescription(tourPackage.getDescription());

        return repository.save(existingPackage);
    }

        @DeleteMapping("/{id}")
    public String deletePackage(@PathVariable Long id) {

        repository.deleteById(id);

        return "Package deleted successfully";
    }

    @GetMapping("/{id}/availability")
public String checkAvailability(
        @PathVariable Long id,
        @RequestParam String date) {

    TourPackage tourPackage = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Package not found"));

    long bookedPeople =
            bookingRepository.sumBookedPeople(
                    tourPackage.getPackageName(),
                    date,
                    "CANCELLED"
            );

    int totalSlots = 20;
    long availableSlots = totalSlots - bookedPeople;

    if (availableSlots < 0) {
        availableSlots = 0;
    }

    return "Available Slots: " + availableSlots;
}
}