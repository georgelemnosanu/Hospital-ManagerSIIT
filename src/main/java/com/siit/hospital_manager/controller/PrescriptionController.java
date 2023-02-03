package com.siit.hospital_manager.controller;

import com.siit.hospital_manager.model.Meds;
import com.siit.hospital_manager.model.Prescription;
import com.siit.hospital_manager.model.dto.AppointmentDto;
import com.siit.hospital_manager.model.dto.CreateAppointmentDto;
import com.siit.hospital_manager.repository.MedsRepository;
import com.siit.hospital_manager.repository.PrescriptionRepository;
import com.siit.hospital_manager.service.PrescriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/prescription")
@RequiredArgsConstructor
public class PrescriptionController {

    private final MedsRepository medsRepository;
    private final PrescriptionService prescriptionService;
    private final PrescriptionRepository prescriptionRepository;
    @GetMapping("/createPrescription")
    public String createPrescriptionForm(Model model) {
        List<Meds> meds = medsRepository.findAll();
        model.addAttribute("prescription",Prescription.builder().build());
        model.addAttribute("meds", meds);
        return "/prescription/createPrescription";
    }


    @PostMapping("/submitCreatePrescription")
    public String createPrescription(Prescription prescription) {
      prescriptionRepository.save(prescription);
      return "/indexUser";
    }

    @GetMapping("/viewPrescription")
    public String findPrescription(Model model) {
        List<Prescription> prescriptions= prescriptionRepository.findAll();
        model.addAttribute("prescriptions", prescriptions);

        return "prescription/viewPrescription";
    }



}
