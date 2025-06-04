// dto/VehicleDTO.java
package com.insurance.insurance.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VehicleDTO {
    private String make;
    private String model;
    private int year;
    private String registrationNumber;
}
