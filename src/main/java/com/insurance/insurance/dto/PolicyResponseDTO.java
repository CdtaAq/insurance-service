// dto/PolicyResponseDTO.java
package com.insurance.insurance.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PolicyResponseDTO {
    private Long id;
    private String policyNumber;
    private String startDate;
    private String endDate;
    private Double premiumAmount;
    private String userEmail;

    private VehicleDTO vehicle;
    private DriverDTO driver;
}
