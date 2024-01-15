package com.foodwallet.virtualbank.api.trade.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TransferResponse {

    private final String fromBankCode;
    private final String fromAccountNumber;
    private final String toBankCode;
    private final String toAccountNumber;
    private final Integer amount;
    private final String content;
    private final LocalDateTime tradeDateTime;

    @Builder
    private TransferResponse(String fromBankCode, String fromAccountNumber, String toBankCode, String toAccountNumber, Integer amount, String content, LocalDateTime tradeDateTime) {
        this.fromBankCode = fromBankCode;
        this.fromAccountNumber = fromAccountNumber;
        this.toBankCode = toBankCode;
        this.toAccountNumber = toAccountNumber;
        this.amount = amount;
        this.content = content;
        this.tradeDateTime = tradeDateTime;
    }
}
