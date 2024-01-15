package com.foodwallet.virtualbank.api.trade.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class DepositResponse {

    private final String bankCode;
    private final String accountNumber;
    private final Integer amount;
    private final String pwd;
    private final String content;
    private final LocalDateTime tradeDateTime;

    @Builder
    private DepositResponse(String bankCode, String accountNumber, Integer amount, String pwd, String content, LocalDateTime tradeDateTime) {
        this.bankCode = bankCode;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.pwd = pwd;
        this.content = content;
        this.tradeDateTime = tradeDateTime;
    }
}
