// src/main/java/com/insurance/insurance/entity/Policy.java
package com.insurance.insurance.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Policy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String policyNumber;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double premiumAmount;

    @ManyToOne(cascade = CascadeType.ALL)
    private Vehicle vehicle;

    @ManyToOne(cascade = CascadeType.ALL)
    private Driver driver;

    private String userEmail; // From authenticated user
}
