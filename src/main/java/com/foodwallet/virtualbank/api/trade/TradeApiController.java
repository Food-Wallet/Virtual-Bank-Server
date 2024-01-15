package com.foodwallet.virtualbank.api.trade;

import com.foodwallet.virtualbank.api.ApiResponse;
import com.foodwallet.virtualbank.api.trade.dto.request.DepositRequest;
import com.foodwallet.virtualbank.api.trade.dto.request.TransferRequest;
import com.foodwallet.virtualbank.api.trade.dto.request.WithdrawalRequest;
import com.foodwallet.virtualbank.api.trade.dto.response.DepositResponse;
import com.foodwallet.virtualbank.api.trade.dto.response.TransferResponse;
import com.foodwallet.virtualbank.api.trade.dto.response.WithdrawalResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/trades")
public class TradeApiController {

    @PostMapping("/transfer")
    public ApiResponse<TransferResponse> transfer(@RequestBody TransferRequest request) {
        TransferResponse response = TransferResponse.builder()
            .fromBankCode("088")
            .fromAccountNumber("110111222222")
            .toBankCode("088")
            .toAccountNumber("110222333333")
            .amount(10000)
            .content("계좌이체")
            .tradeDateTime(LocalDateTime.of(2024, 1, 15, 9, 0))
            .build();

        return ApiResponse.ok(response);
    }

    @PostMapping("/deposit")
    public ApiResponse<DepositResponse> deposit(@RequestBody DepositRequest request) {
        return null;
    }

    @PostMapping("/withdrawal")
    public ApiResponse<WithdrawalResponse> withdrawal(@RequestBody WithdrawalRequest request) {
        return null;
    }
}
