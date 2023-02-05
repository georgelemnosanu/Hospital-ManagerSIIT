package com.siit.hospital_manager.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateAdminDto {
    @NotNull(message = "userName can not be null")
    private String userName;
    @NotNull(message = "Password can not be null")
    private String password;


}
