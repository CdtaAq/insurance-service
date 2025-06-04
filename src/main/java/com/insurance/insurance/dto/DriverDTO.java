// dto/DriverDTO.java
package com.insurance.insurance.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DriverDTO {
    private String fullName;
    private int age;
    private String licenseNumber;
    private String location;
}
