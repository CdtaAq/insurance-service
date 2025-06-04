// controller/PolicyController.java
package com.insurance.insurance.controller;

import com.insurance.insurance.dto.PolicyRequestDTO;
import com.insurance.insurance.dto.PolicyResponseDTO;
import com.insurance.insurance.service.PolicyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/policies")
@RequiredArgsConstructor
@CrossOrigin(origins = "*") // Allow frontend access
public class PolicyController {

    private final PolicyService policyService;

    @PostMapping
    public ResponseEntity<PolicyResponseDTO> createPolicy(@RequestBody PolicyRequestDTO dto) {
        return ResponseEntity.ok(policyService.createPolicy(dto));
    }

    @GetMapping("/user")
    public ResponseEntity<List<PolicyResponseDTO>> getPoliciesByUser(@RequestParam String email) {
        return ResponseEntity.ok(policyService.getPoliciesByUser(email));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PolicyResponseDTO> getPolicyById(@PathVariable Long id) {
        return ResponseEntity.ok(policyService.getPolicyById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePolicy(@PathVariable Long id) {
        policyService.deletePolicy(id);
        return ResponseEntity.noContent().build();
    }
}
