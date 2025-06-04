// service/PolicyServiceImpl.java
package com.insurance.insurance.service;

import com.insurance.insurance.dto.*;
import com.insurance.insurance.entity.*;
import com.insurance.insurance.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PolicyServiceImpl implements PolicyService {

    private final PolicyRepository policyRepository;
    private final VehicleRepository vehicleRepository;
    private final DriverRepository driverRepository;

    @Override
    public PolicyResponseDTO createPolicy(PolicyRequestDTO dto) {
        Vehicle vehicle = vehicleRepository.save(
            Vehicle.builder()
                .make(dto.getVehicle().getMake())
                .model(dto.getVehicle().getModel())
                .year(dto.getVehicle().getYear())
                .registrationNumber(dto.getVehicle().getRegistrationNumber())
                .build()
        );

        Driver driver = driverRepository.save(
            Driver.builder()
                .fullName(dto.getDriver().getFullName())
                .age(dto.getDriver().getAge())
                .licenseNumber(dto.getDriver().getLicenseNumber())
                .location(dto.getDriver().getLocation())
                .build()
        );

        Policy policy = Policy.builder()
            .policyNumber(dto.getPolicyNumber())
            .startDate(LocalDate.parse(dto.getStartDate()))
            .endDate(LocalDate.parse(dto.getEndDate()))
            .premiumAmount(dto.getPremiumAmount())
            .userEmail(dto.getUserEmail())
            .vehicle(vehicle)
            .driver(driver)
            .build();

        Policy saved = policyRepository.save(policy);
        return mapToResponse(saved);
    }

    @Override
    public List<PolicyResponseDTO> getPoliciesByUser(String email) {
        return policyRepository.findByUserEmail(email)
            .stream()
            .map(this::mapToResponse)
            .collect(Collectors.toList());
    }

    @Override
    public PolicyResponseDTO getPolicyById(Long id) {
        return policyRepository.findById(id)
            .map(this::mapToResponse)
            .orElseThrow(() -> new RuntimeException("Policy not found"));
    }

    @Override
    public void deletePolicy(Long id) {
        policyRepository.deleteById(id);
    }

    private PolicyResponseDTO mapToResponse(Policy policy) {
        return PolicyResponseDTO.builder()
            .id(policy.getId())
            .policyNumber(policy.getPolicyNumber())
            .startDate(policy.getStartDate().toString())
            .endDate(policy.getEndDate().toString())
            .premiumAmount(policy.getPremiumAmount())
            .userEmail(policy.getUserEmail())
            .vehicle(VehicleDTO.builder()
                .make(policy.getVehicle().getMake())
                .model(policy.getVehicle().getModel())
                .year(policy.getVehicle().getYear())
                .registrationNumber(policy.getVehicle().getRegistrationNumber())
                .build())
            .driver(DriverDTO.builder()
                .fullName(policy.getDriver().getFullName())
                .age(policy.getDriver().getAge())
                .licenseNumber(policy.getDriver().getLicenseNumber())
                .location(policy.getDriver().getLocation())
                .build())
            .build();
    }
}
