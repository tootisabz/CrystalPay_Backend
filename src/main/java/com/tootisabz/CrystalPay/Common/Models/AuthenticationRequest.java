package com.tootisabz.CrystalPay.Common.Models;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AuthenticationRequest {
    @Schema(description = "The user name of a registered user",example = "Admin",defaultValue = "Admin")
    private String username;
    @Schema(description = "The user password of a registered user",example = "admin",defaultValue = "admin")
    private String password;
}