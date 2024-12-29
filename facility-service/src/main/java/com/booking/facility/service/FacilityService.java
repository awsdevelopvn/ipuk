package main.java.com.booking.facility.service;

// src/main/java/com/booking/facility/service/FacilityService.java
@Service
@Slf4j
@Transactional
public class FacilityService {
    private final FacilityRepository facilityRepository;
    private final ReviewRepository reviewRepository;

    public FacilityService(FacilityRepository facilityRepository, ReviewRepository reviewRepository) {
        this.facilityRepository = facilityRepository;
        this.reviewRepository = reviewRepository;
    }

    public Facility createFacility(FacilityInput input) {
        Facility facility = new Facility();
        BeanUtils.copyProperties(input, facility);
        return facilityRepository.save(facility);
    }

    public Facility updateFacility(Long id, FacilityInput input) {
        Facility facility = facilityRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Facility not found"));
        
        BeanUtils.copyProperties(input, facility);
        return facilityRepository.save(facility);
    }

    public void deleteFacility(Long id) {
        facilityRepository.deleteById(id);
    }

    public Facility getFacility(Long id) {
        return facilityRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Facility not found"));
    }

    public Page<Facility> searchFacilities(String query, Pageable pageable) {
        return facilityRepository.findByNameContainingOrDescriptionContainingOrLocationContaining(
            query, query, query, pageable);
    }

    public Review addReview(Long facilityId, ReviewInput input) {
        Facility facility = getFacility(facilityId);
        
        Review review = new Review();
        review.setFacility(facility);
        review.setRating(input.getRating());
        review.setComment(input.getComment());
        review.setCreatedAt(LocalDateTime.now());
        
        return reviewRepository.save(review);
    }
}