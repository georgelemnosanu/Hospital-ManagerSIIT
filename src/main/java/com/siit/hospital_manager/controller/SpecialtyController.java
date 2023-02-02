package com.siit.hospital_manager.controller;

import com.siit.hospital_manager.model.Specialty;
import com.siit.hospital_manager.service.SpecialtyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/specialty")
@RequiredArgsConstructor
public class SpecialtyController {

    private final SpecialtyService specialtyService;

    @GetMapping("/{specialtyId}")
    public String showSpecialtyPage(@PathVariable Integer specialtyId, Model model) {
        model.addAttribute("specialty", specialtyService.findById(specialtyId));
        return "/specialty/showSpecialty";
    }

}