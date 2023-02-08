package com.siit.hospital_manager.service;

import com.siit.hospital_manager.exception.BusinessException;
import com.siit.hospital_manager.model.Admin;
import com.siit.hospital_manager.model.User;
import com.siit.hospital_manager.model.dto.CreateAdminDto;
import com.siit.hospital_manager.repository.AdminRepository;
import com.siit.hospital_manager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AdminRepository adminRepository;


    public void createAdmin(CreateAdminDto createAdminDto) {

        userRepository.findByUserName(createAdminDto.getUserName()).ifPresent(user ->{throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"User already Exist");
        });

        User admin = Admin.builder()
                .userName(createAdminDto.getUserName())
                .password(passwordEncoder.encode(createAdminDto.getPassword()))
                .isActive(true)
                .roles("ROLE_ADMIN")
                .build();
        userRepository.save(admin);
    }

    @Transactional
    public void deleteAdminByID(Integer id){
        Admin admin = adminRepository.findById(id).orElseThrow(
                () -> new BusinessException(HttpStatus.NOT_FOUND, "Invalid admin id"));
        adminRepository.delete(admin);

    }


}
