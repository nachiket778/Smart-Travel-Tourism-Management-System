package com.Travel.Smart.Travel.Tourism;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PackageDataLoader implements CommandLineRunner {

    private final TourPackageRepository repository;

    public PackageDataLoader(TourPackageRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) {

        // Run only when the old 8-package data is present
        if (repository.count() <= 8) {

            repository.deleteAll();

            List<TourPackage> packages = new ArrayList<>();

            packages.add(create("Gateway of India Tour", "Mumbai",
                    "1 Day", 1499, "Visit the iconic Gateway of India and explore South Mumbai.",
                    "Famous Places"));

            packages.add(create("Marine Drive Experience", "Mumbai",
                    "1 Day", 1299, "Enjoy the beautiful Queen's Necklace and Mumbai coastline.",
                    "Famous Places"));

            packages.add(create("Elephanta Caves Tour", "Mumbai",
                    "1 Day", 1999, "Explore the historic Elephanta Caves and island surroundings.",
                    "Famous Places"));

            packages.add(create("Lonavala Sightseeing", "Lonavala",
                    "2 Days / 1 Night", 3999, "Explore scenic viewpoints, waterfalls and valleys of Lonavala.",
                    "Famous Places"));

            packages.add(create("Mahabaleshwar Tour", "Mahabaleshwar",
                    "2 Days / 1 Night", 4499, "Explore scenic viewpoints, hills and famous attractions.",
                    "Famous Places"));

            packages.add(create("Shirdi Sai Baba Temple Tour", "Shirdi",
                    "2 Days / 1 Night", 3499, "Visit the famous Sai Baba temple and nearby attractions.",
                    "TOP Temples"));

            packages.add(create("Trimbakeshwar Jyotirlinga Tour", "Nashik",
                    "2 Days / 1 Night", 3299, "Visit the historic Trimbakeshwar Jyotirlinga temple.",
                    "TOP Temples"));

            packages.add(create("Bhimashankar Jyotirlinga Tour", "Pune",
                    "2 Days / 1 Night", 3599, "Visit Bhimashankar Jyotirlinga surrounded by natural beauty.",
                    "TOP Temples"));

            packages.add(create("Grishneshwar Jyotirlinga Tour", "Aurangabad",
                    "2 Days / 1 Night", 3999, "Visit Grishneshwar Jyotirlinga near the Ellora Caves.",
                    "TOP Temples"));

            packages.add(create("Siddhivinayak Temple Tour", "Mumbai",
                    "1 Day", 1299, "Visit the famous Siddhivinayak Temple in Mumbai.",
                    "TOP Temples"));

            packages.add(create("CSMT Heritage Tour", "Mumbai",
                    "1 Day", 1499, "Explore the historic Chhatrapati Shivaji Maharaj Terminus.",
                    "Historical Places"));

            packages.add(create("Aga Khan Palace Tour", "Pune",
                    "1 Day", 1699, "Explore the historic Aga Khan Palace and its heritage.",
                    "Historical Places"));

            packages.add(create("Raigad Historical Tour", "Raigad",
                    "2 Days / 1 Night", 2999, "Explore the historic Raigad Fort and Maratha heritage.",
                    "Historical Places"));

            packages.add(create("Ajanta Caves Tour", "Aurangabad",
                    "2 Days / 1 Night", 3999, "Explore the ancient Ajanta rock-cut caves and paintings.",
                    "Historical Places"));

            packages.add(create("Ellora Caves Tour", "Aurangabad",
                    "2 Days / 1 Night", 3999, "Explore the magnificent Ellora rock-cut cave temples.",
                    "Historical Places"));

            packages.add(create("Alibaug Beach Tour", "Alibaug",
                    "2 Days / 1 Night", 2999, "Relax at Alibaug Beach and explore the nearby coastline.",
                    "Beaches"));

            packages.add(create("Kashid Beach Escape", "Kashid",
                    "2 Days / 1 Night", 3499, "Enjoy the peaceful Kashid Beach and coastal surroundings.",
                    "Beaches"));

            packages.add(create("Ganpatipule Beach Tour", "Ganpatipule",
                    "2 Days / 1 Night", 3999, "Enjoy the beautiful beach and coastal attractions of Ganpatipule.",
                    "Beaches"));

            packages.add(create("Tarkarli Beach Tour", "Tarkarli",
                    "3 Days / 2 Nights", 4999, "Enjoy beaches, coastal scenery and water activities.",
                    "Beaches"));

            packages.add(create("Harihareshwar Beach Tour", "Harihareshwar",
                    "2 Days / 1 Night", 3299, "Explore the peaceful beach and coastal surroundings.",
                    "Beaches"));

            packages.add(create("Tadoba Tiger Reserve Tour", "Tadoba",
                    "3 Days / 2 Nights", 6999, "Explore Tadoba-Andhari Tiger Reserve and its wildlife.",
                    "Wildlife & National Parks"));

            packages.add(create("Sanjay Gandhi National Park Tour", "Mumbai",
                    "1 Day", 1799, "Explore wildlife and nature inside Sanjay Gandhi National Park.",
                    "Wildlife & National Parks"));

            packages.add(create("Pench National Park Tour", "Pench",
                    "3 Days / 2 Nights", 6499, "Experience wildlife and natural beauty at Pench National Park.",
                    "Wildlife & National Parks"));

            packages.add(create("Navegaon-Nagzira Wildlife Tour", "Gondia",
                    "3 Days / 2 Nights", 5999, "Explore forests, wildlife and natural landscapes.",
                    "Wildlife & National Parks"));

            packages.add(create("Melghat Tiger Reserve Tour", "Melghat",
                    "3 Days / 2 Nights", 6499, "Explore forests and wildlife at Melghat Tiger Reserve.",
                    "Wildlife & National Parks"));

            packages.add(create("Lonavala Farmhouse Day Trip", "Lonavala",
                    "1 Day", 1999, "Enjoy a peaceful farmhouse and picnic experience in Lonavala.",
                    "Farmhouse / Picnic"));

            packages.add(create("Karjat Farmhouse Escape", "Karjat",
                    "1 Day", 2199, "Relax at a peaceful farmhouse surrounded by nature.",
                    "Farmhouse / Picnic"));

            packages.add(create("Alibaug Farmhouse Retreat", "Alibaug",
                    "1 Day", 2299, "Enjoy a relaxing farmhouse and picnic experience near Alibaug.",
                    "Farmhouse / Picnic"));

            packages.add(create("Igatpuri Farmhouse Picnic", "Igatpuri",
                    "1 Day", 2199, "Enjoy a peaceful picnic surrounded by hills and greenery.",
                    "Farmhouse / Picnic"));

            packages.add(create("Murbad Farmhouse Getaway", "Murbad",
                    "1 Day", 1999, "Relax with a peaceful farmhouse and nature getaway.",
                    "Farmhouse / Picnic"));

            repository.saveAll(packages);

            System.out.println("30 Maharashtra tour packages inserted successfully.");
        }
    }

    private TourPackage create(
            String name,
            String destination,
            String duration,
            double price,
            String description,
            String category) {

        TourPackage p = new TourPackage(
                name,
                destination,
                duration,
                price,
                description
        );

        p.setCategory(category);

        return p;
    }
}