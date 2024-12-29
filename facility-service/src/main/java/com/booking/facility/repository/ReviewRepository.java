package main.java.com.booking.facility.repository;

// src/main/java/com/booking/facility/repository/ReviewRepository.java
@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByFacilityId(Long facilityId);
    Optional<Double> findAverageRatingByFacilityId(Long facilityId);
}