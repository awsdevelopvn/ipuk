package main.java.com.booking.facility.controller;

// src/main/java/com/booking/facility/controller/FacilityController.java
@Controller
public class FacilityController {
    private final FacilityService facilityService;

    public FacilityController(FacilityService facilityService) {
        this.facilityService = facilityService;
    }

    @QueryMapping
    public Facility facility(@Argument Long id) {
        return facilityService.getFacility(id);
    }

    @QueryMapping
    public Page<Facility> facilities(@Argument int page, @Argument int size) {
        return facilityService.getFacilities(PageRequest.of(page, size));
    }

    @QueryMapping
    public Page<Facility> searchFacilities(
        @Argument String query, 
        @Argument int page, 
        @Argument int size
    ) {
        return facilityService.searchFacilities(query, PageRequest.of(page, size));
    }

    @MutationMapping
    public Facility createFacility(@Argument FacilityInput input) {
        return facilityService.createFacility(input);
    }

    @MutationMapping
    public Facility updateFacility(@Argument Long id, @Argument FacilityInput input) {
        return facilityService.updateFacility(id, input);
    }

    @MutationMapping
    public Boolean deleteFacility(@Argument Long id) {
        facilityService.deleteFacility(id);
        return true;
    }

    @MutationMapping
    public Review addReview(@Argument Long facilityId, @Argument ReviewInput input) {
        return facilityService.addReview(facilityId, input);
    }
}