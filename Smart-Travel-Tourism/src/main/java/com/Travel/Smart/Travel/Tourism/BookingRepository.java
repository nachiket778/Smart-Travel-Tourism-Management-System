package com.Travel.Smart.Travel.Tourism;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Query("""
        SELECT COALESCE(SUM(b.numberOfPeople), 0)
        FROM Booking b
        WHERE b.packageName = :packageName
          AND b.travelDate = :travelDate
          AND b.status <> :status
    """)
    long sumBookedPeople(
            @Param("packageName") String packageName,
            @Param("travelDate") String travelDate,
            @Param("status") String status
    );
}