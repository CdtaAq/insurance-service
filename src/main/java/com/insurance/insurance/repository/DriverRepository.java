// src/main/java/com/insurance/insurance/repository/DriverRepository.java
package com.insurance.insurance.repository;

import com.insurance.insurance.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
}
