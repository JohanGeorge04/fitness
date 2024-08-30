// src/main/java/com/fitness/platform/repository/FitnessPlanRepository.java

package com.fitness.platform.repository;

import com.fitness.platform.entity.FitnessPlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FitnessPlanRepository extends JpaRepository<FitnessPlan, Long> {
}
