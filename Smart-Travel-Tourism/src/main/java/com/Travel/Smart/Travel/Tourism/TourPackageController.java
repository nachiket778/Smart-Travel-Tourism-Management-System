package com.Travel.Smart.Travel.Tourism;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/packages")
public class TourPackageController {

    private final TourPackageRepository repository;

    public TourPackageController(TourPackageRepository repository) {
        this.repository = repository;
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
}