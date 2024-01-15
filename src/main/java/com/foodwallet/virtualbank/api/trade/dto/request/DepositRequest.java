package com.foodwallet.virtualbank.api.trade.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DepositRequest {

    private String bankCode;
    private String accountNumber;
    private Integer amount;
    private String pwd;
    private String content;

    @Builder
    private DepositRequest(String bankCode, String accountNumber, Integer amount, String pwd, String content) {
        this.bankCode = bankCode;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.pwd = pwd;
        this.content = content;
    }
}
