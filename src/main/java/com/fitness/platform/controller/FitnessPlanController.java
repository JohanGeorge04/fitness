// src/main/java/com/fitness/platform/controller/FitnessPlanController.java

package com.fitness.platform.controller;

import com.fitness.platform.entity.FitnessPlan;
import com.fitness.platform.service.FitnessPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FitnessPlanController {
    @Autowired
    private FitnessPlanService fitnessPlanService;

    @GetMapping("/plans")
    public String getAllPlans(Model model) {
        model.addAttribute("plans", fitnessPlanService.getAllPlans());
        return "plans";
    }

    @GetMapping("/plans/new")
    public String showPlanForm(Model model) {
        model.addAttribute("plan", new FitnessPlan());
        return "plan-form";
    }

    @PostMapping("/plans")
    public String createPlan(FitnessPlan plan) {
        fitnessPlanService.createPlan(plan);
        return "redirect:/plans";
    }
}
