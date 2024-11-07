package com.tootisabz.CrystalPay.Common.Enums;

import lombok.NoArgsConstructor;

import java.util.Objects;

@NoArgsConstructor
public class EnumDetails {

    public String getName(FinTechTransactionStatus Enum) {
        if (Objects.requireNonNull(Enum) == FinTechTransactionStatus.FAILURE) {
            return "FAILURE";
        } else if (Objects.requireNonNull(Enum) == FinTechTransactionStatus.SUCCESS) {
            return "SUCCESS";
        } else if (Objects.requireNonNull(Enum) == FinTechTransactionStatus.IN_PROGRESS) {
            return "IN_PROGRESS";
        } else if (Objects.requireNonNull(Enum) == FinTechTransactionStatus.FAILURE_BAD_CREDENTIALS) {
            return "FAILURE_BAD_CREDENTIALS";
        } else if (Objects.requireNonNull(Enum) == FinTechTransactionStatus.FAILURE_NOT_SUFFICIENT_BALANCE) {
            return "FAILURE_NOT_SUFFICIENT_BALANCE";
        } else if (Objects.requireNonNull(Enum) == FinTechTransactionStatus.PENDING) {
            return "PENDING";
        }
        return "FAILURE";
    }


}
