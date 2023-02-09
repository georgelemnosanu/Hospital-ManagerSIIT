package com.siit.hospital_manager.dataloader;

import com.siit.hospital_manager.model.*;
import com.siit.hospital_manager.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;


//@Component
@RequiredArgsConstructor
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private final BCryptPasswordEncoder encoder;
    private final SpecialtyRepository specialtyRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final ProcedureRepository procedureRepository;
    private final DiagnosisRepository diagnosisRepository;
    private final MedicationRepository medicationRepository;
    private final AppointmentsRepository appointmentsRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        //creating specialties
        Specialty cardiology = Specialty.builder()
                .id(1)
                .name("Cardiology")
                .description("Cardiology is a medical specialty that deals with the diagnosis, " +
                        "treatment and prevention of diseases related to the heart and blood vessels (cardiovascular system). " +
                        "Cardiologists are trained in diagnosing and managing conditions such as heart attacks, heart failure, " +
                        "arrhythmias, congenital heart defects, and hypertension, among others. The field of cardiology also " +
                        "includes non-invasive and invasive procedures for diagnosing and treating heart conditions, " +
                        "such as stress tests, electrocardiograms, and angioplasties.")
                .build();
        Specialty rheumatology = Specialty.builder()
                .id(2)
                .name("Rheumatology")
                .description("Rheumatology is a medical specialty that focuses on the diagnosis and treatment of rheumatic diseases," +
                        " which are conditions that affect the joints, bones, and muscles. " +
                        "These diseases often cause inflammation, pain, and stiffness, and can also affect internal organs and the immune system. " +
                        "Rheumatologists use a combination of physical exams, lab tests, imaging studies, " +
                        "and patient history to diagnose and manage these conditions, which can include arthritis, lupus, " +
                        "fibromyalgia, and gout, among others.")
                .build();

        specialtyRepository.save(cardiology);
        specialtyRepository.save(rheumatology);

        //creating doctors
        Doctor doctor1 = Doctor.builder()
                .userName("doctor1")
                .password(encoder.encode("doctor1"))
                .isActive(true)
                .roles("ROLE_DOCTOR")
                .name("Gregory House")
                .specialty(cardiology)
                .build();

        Doctor doctor2 = Doctor.builder()
                .userName("doctor2")
                .password(encoder.encode("doctor2"))
                .isActive(true)
                .roles("ROLE_DOCTOR")
                .name("James Wilson")
                .specialty(rheumatology)
                .build();

        doctorRepository.save(doctor1);
        doctorRepository.save(doctor2);

        //creating patients
        Patient patient1 = Patient.builder()
                .userName("patient1")
                .password(encoder.encode("patient1"))
                .isActive(true)
                .roles("ROLE_PATIENT")
                .name("Will Smith")
                .age(33)
                .phoneNumber("0752111222")
                .email("patient1@mail.com")
                .build();

        Patient patient2 = Patient.builder()
                .userName("patient2")
                .password(encoder.encode("patient2"))
                .isActive(true)
                .roles("ROLE_PATIENT")
                .name("Harry Potter")
                .age(21)
                .phoneNumber("0752111222")
                .email("patient2@mail.com")
                .build();

        patientRepository.save(patient1);
        patientRepository.save(patient2);

        //creating procedures
        Procedure eco = Procedure.builder()
                .name("Echocardiography")
                .build();

        Procedure xRay = Procedure.builder()
                .name("X-Ray")
                .build();

        procedureRepository.save(eco);
        procedureRepository.save(xRay);

        //creating Diagnoses
        Diagnosis diagnosis1 = Diagnosis.builder()
                .name("Hypertension")
                .build();

        diagnosisRepository.save(diagnosis1);

        //creating Medications
        Medication enalapril = Medication.builder()
                .name("Enalapril")
                .build();

        medicationRepository.save(enalapril);


        //creating appointments


    }
}