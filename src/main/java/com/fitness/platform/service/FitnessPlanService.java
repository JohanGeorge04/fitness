// src/main/java/com/fitness/platform/service/FitnessPlanService.java

package com.fitness.platform.service;

import com.fitness.platform.entity.FitnessPlan;
import com.fitness.platform.repository.FitnessPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FitnessPlanService {
    @Autowired
    private FitnessPlanRepository fitnessPlanRepository;

    public List<FitnessPlan> getAllPlans() {
        return fitnessPlanRepository.findAll();
    }

    public FitnessPlan createPlan(FitnessPlan plan) {
        return fitnessPlanRepository.save(plan);
    }
}
