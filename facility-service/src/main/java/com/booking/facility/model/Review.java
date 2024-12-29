package main.java.com.booking.facility.model;

// src/main/java/com/booking/facility/model/Review.java
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "facility_id")
    private Facility facility;
    
    private Long userId;
    private Integer rating;
    private String comment;
    private LocalDateTime createdAt;
}
