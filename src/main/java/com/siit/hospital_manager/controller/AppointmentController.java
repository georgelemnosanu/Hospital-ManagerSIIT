package com.siit.hospital_manager.controller;

import com.siit.hospital_manager.config.MyUserDetails;
import com.siit.hospital_manager.model.Medication;
import com.siit.hospital_manager.model.Patient;
import com.siit.hospital_manager.model.Specialty;
import com.siit.hospital_manager.model.dto.AppointmentDto;
import com.siit.hospital_manager.model.dto.CreateAppointmentDto;
import com.siit.hospital_manager.repository.MedicationRepository;
import com.siit.hospital_manager.repository.SpecialtyRepository;
import com.siit.hospital_manager.service.AppointmentService;
import com.siit.hospital_manager.service.DoctorService;
import com.siit.hospital_manager.service.EmailSender;
import com.siit.hospital_manager.service.PatientService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/appointment")

@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final DoctorService doctorService;
    private final PatientService patientService;
    private final SpecialtyRepository specialtyRepository;

    private final EmailSender emailSender;

    @GetMapping("/findAllByPatient")
    public String findAllByPatient(Model model, Principal principal) {
        List<AppointmentDto> appointments = appointmentService.findAllByUserName(principal.getName());
        model.addAttribute("appointments", appointments);
        return "appointment/viewAll";
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteAppointmentById(Model model, @PathVariable Integer id, Principal principal){
         appointmentService.deleteAppointmentByIdAndPatient(id, principal.getName());
    }

    @GetMapping("/create/{specialtyId}")
    public String showCreateSpecialtyForm(@PathVariable Integer specialtyId, Model model) {
        Specialty specialty = specialtyRepository.findById(specialtyId)
                .orElseThrow(() -> new EntityNotFoundException("Specialty not found"));
        model.addAttribute("doctors", doctorService.findAllBySpecialty(specialty));
        model.addAttribute("appointment", CreateAppointmentDto.builder().build());
        return "/appointment/createAppointment";
    }

    @PostMapping("/submitCreateAppointmentForm")
    public String submitCreateAppointmentForm(CreateAppointmentDto createAppointmentDto, BindingResult bindingResult, Authentication authentication) {
        MyUserDetails myUserDetails = (MyUserDetails) authentication.getPrincipal();
        String username = myUserDetails.getUsername();
        Patient patient = patientService.findByUsername(username);
        String userEmail = patient != null ? patient.getEmail() : null;
        emailSender.sendAppointmentConfirmationEmail(userEmail, "Appointment Confirmation",
                "Your appointment has been confirmed we wait you at: " + createAppointmentDto.getDate());
        appointmentService.save(createAppointmentDto);
        return "/appointment/appointmentCreatedSuccessfully";
    }
}
