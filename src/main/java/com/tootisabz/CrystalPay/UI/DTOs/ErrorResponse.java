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
public class ErrorResponse {
    @Schema(description = "The Error message for user",example = "Bad Credentials !")
    private String message;

}
