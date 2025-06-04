// dto/PolicyRequestDTO.java
package com.insurance.insurance.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PolicyRequestDTO {
    private String policyNumber;
    private String startDate;   // ISO format (e.g., 2025-06-03)
    private String endDate;
    private Double premiumAmount;
    private String userEmail;

    private VehicleDTO vehicle;
    private DriverDTO driver;
}
