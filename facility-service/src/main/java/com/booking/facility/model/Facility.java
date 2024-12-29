// src/main/java/com/booking/facility/model/Facility.java
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String description;
    private String location;
    private BigDecimal price;
    private Integer capacity;
    
    @OneToMany(mappedBy = "facility", cascade = CascadeType.ALL)
    private List<Review> reviews;
    
    @Enumerated(EnumType.STRING)
    private FacilityStatus status;
}