// src/main/java/com/insurance/insurance/repository/VehicleRepository.java
package com.insurance.insurance.repository;

import com.insurance.insurance.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
