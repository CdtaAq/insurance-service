// src/main/java/com/insurance/insurance/repository/PolicyRepository.java
package com.insurance.insurance.repository;

import com.insurance.insurance.entity.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PolicyRepository extends JpaRepository<Policy, Long> {
    List<Policy> findByUserEmail(String userEmail);
}
