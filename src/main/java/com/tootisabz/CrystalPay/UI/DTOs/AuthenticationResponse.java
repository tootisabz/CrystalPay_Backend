package com.tootisabz.CrystalPay.UI.DTOs;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuthenticationResponse {
    @Schema(description = "The Jwt Token used for authentication and authorization",example = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJBZG1pbiIsImlhdCI6MTczMDc4NTkwOSwiZXhwIjoxNzMwODIxOTA5LCJpc3MiOiJpc3N1ZSJ9.JL6lBh1agDqmtZUAPXjfgqQBWfpu1LwlTfqeTKm8Vhc")
    private String token;

}
