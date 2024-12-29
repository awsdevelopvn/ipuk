// src/main/java/com/booking/facility/repository/FacilityRepository.java
@Repository
public interface FacilityRepository extends JpaRepository<Facility, Long> {
    Page<Facility> findByNameContainingOrDescriptionContainingOrLocationContaining(
        String name, String description, String location, Pageable pageable);
}