package com.foodwallet.virtualbank.api.trade.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class WithdrawalResponse {

    private final String bankCode;
    private final String accountNumber;
    private final Integer amount;
    private final String content;
    private final LocalDateTime withdrawalDateTime;

    @Builder
    private WithdrawalResponse(String bankCode, String accountNumber, Integer amount, String content, LocalDateTime withdrawalDateTime) {
        this.bankCode = bankCode;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.content = content;
        this.withdrawalDateTime = withdrawalDateTime;
    }
}
