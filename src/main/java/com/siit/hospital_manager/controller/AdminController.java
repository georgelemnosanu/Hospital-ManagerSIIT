package com.siit.hospital_manager.controller;

import com.siit.hospital_manager.model.dto.CreateAdminDto;
import com.siit.hospital_manager.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;
    @GetMapping("/createAdmin")
    public String createAdmin(Model model){
        model.addAttribute("admin", CreateAdminDto.builder().build());
        return "/admin/createAdmin";
    }

    @PostMapping("/submitCreateAdmin")
    public String submitAdmin(CreateAdminDto createAdminDto){
       try {
           adminService.createAdmin(createAdminDto);
       }catch (ResponseStatusException e){
           return "/entityExistsError";
       }
        return "/index";
    }


}
