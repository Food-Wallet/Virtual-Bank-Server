package com.foodwallet.virtualbank.api.trade.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TransferRequest {

    private String fromBankCode;
    private String fromAccountNumber;
    private String toBankCode;
    private String toAccountNumber;
    private Integer amount;
    private String content;

    @Builder
    private TransferRequest(String fromBankCode, String fromAccountNumber, String toBankCode, String toAccountNumber, Integer amount, String content) {
        this.fromBankCode = fromBankCode;
        this.fromAccountNumber = fromAccountNumber;
        this.toBankCode = toBankCode;
        this.toAccountNumber = toAccountNumber;
        this.amount = amount;
        this.content = content;
    }
}
