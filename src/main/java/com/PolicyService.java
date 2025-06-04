// service/PolicyService.java
package com.insurance.insurance.service;

import com.insurance.insurance.dto.PolicyRequestDTO;
import com.insurance.insurance.dto.PolicyResponseDTO;

import java.util.List;

public interface PolicyService {
    PolicyResponseDTO createPolicy(PolicyRequestDTO dto);
    List<PolicyResponseDTO> getPoliciesByUser(String email);
    PolicyResponseDTO getPolicyById(Long id);
    void deletePolicy(Long id);
}
