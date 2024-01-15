package com.foodwallet.virtualbank.docs.trade;

import com.foodwallet.virtualbank.api.trade.TradeApiController;
import com.foodwallet.virtualbank.api.trade.dto.request.DepositRequest;
import com.foodwallet.virtualbank.api.trade.dto.request.TransferRequest;
import com.foodwallet.virtualbank.docs.RestDocsSupport;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.JsonFieldType;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class TradeApiControllerDocsTest extends RestDocsSupport {

    private static final String BASE_URL = "/api/v1/trades";

    @Override
    protected Object initController() {
        return new TradeApiController();
    }

    @DisplayName("계좌 이체하는 API")
    @Test
    void transfer() throws Exception {
        TransferRequest request = TransferRequest.builder()
            .fromBankCode("088")
            .fromAccountNumber("110111222222")
            .toBankCode("088")
            .toAccountNumber("110222333333")
            .amount(10000)
            .content("계좌이체")
            .build();

        mockMvc.perform(
                post(BASE_URL + "/transfer")
                    .content(objectMapper.writeValueAsString(request))
                    .contentType(MediaType.APPLICATION_JSON)
            )
            .andDo(print())
            .andExpect(status().isOk())
            .andDo(document("transfer",
                preprocessRequest(prettyPrint()),
                preprocessResponse(prettyPrint()),
                requestFields(
                    fieldWithPath("fromBankCode").type(JsonFieldType.STRING)
                        .description("보내는 은행 코드"),
                    fieldWithPath("fromAccountNumber").type(JsonFieldType.STRING)
                        .description("보내는 계좌 번호"),
                    fieldWithPath("toBankCode").type(JsonFieldType.STRING)
                        .description("받는 은행 코드"),
                    fieldWithPath("toAccountNumber").type(JsonFieldType.STRING)
                        .description("받는 계좌 번호"),
                    fieldWithPath("amount").type(JsonFieldType.NUMBER)
                        .description("금액"),
                    fieldWithPath("content").type(JsonFieldType.STRING)
                        .optional()
                        .description("이체 내용")
                ),
                responseFields(
                    fieldWithPath("code").type(JsonFieldType.NUMBER)
                        .description("코드"),
                    fieldWithPath("status").type(JsonFieldType.STRING)
                        .description("상태"),
                    fieldWithPath("message").type(JsonFieldType.STRING)
                        .description("메시지"),
                    fieldWithPath("data").type(JsonFieldType.OBJECT)
                        .description("응답 데이터"),
                    fieldWithPath("data.fromBankCode").type(JsonFieldType.STRING)
                        .description("보내는 은행 코드"),
                    fieldWithPath("data.fromAccountNumber").type(JsonFieldType.STRING)
                        .description("보내는 계좌 번호"),
                    fieldWithPath("data.toBankCode").type(JsonFieldType.STRING)
                        .description("받는 은행 코드"),
                    fieldWithPath("data.toAccountNumber").type(JsonFieldType.STRING)
                        .description("받는 계좌 번호"),
                    fieldWithPath("data.amount").type(JsonFieldType.NUMBER)
                        .description("금액"),
                    fieldWithPath("data.content").type(JsonFieldType.STRING)
                        .description("이체 내용"),
                    fieldWithPath("data.tradeDateTime").type(JsonFieldType.ARRAY)
                        .description("이체 시간")
                )
            ));
    }

    @DisplayName("계좌 입금하는 API")
    @Test
    void deposit() throws Exception {
        DepositRequest request = DepositRequest.builder()
            .bankCode("088")
            .accountNumber("110111222222")
            .amount(10000)
            .pwd("1234")
            .content("입금")
            .build();

        mockMvc.perform(
                post(BASE_URL + "/deposit")
                    .content(objectMapper.writeValueAsString(request))
                    .contentType(MediaType.APPLICATION_JSON)
            )
            .andDo(print())
            .andExpect(status().isOk())
            .andDo(document("deposit",
                preprocessRequest(prettyPrint()),
                preprocessResponse(prettyPrint()),
                requestFields(
                    fieldWithPath("bankCode").type(JsonFieldType.STRING)
                        .description("입금할 은행 코드"),
                    fieldWithPath("accountNumber").type(JsonFieldType.STRING)
                        .description("입금할 계좌 번호"),
                    fieldWithPath("amount").type(JsonFieldType.NUMBER)
                        .description("금액"),
                    fieldWithPath("pwd").type(JsonFieldType.STRING)
                        .description("계좌 비밀번호"),
                    fieldWithPath("content").type(JsonFieldType.STRING)
                        .optional()
                        .description("이체 내용")
                ),
                responseFields(
                    fieldWithPath("code").type(JsonFieldType.NUMBER)
                        .description("코드"),
                    fieldWithPath("status").type(JsonFieldType.STRING)
                        .description("상태"),
                    fieldWithPath("message").type(JsonFieldType.STRING)
                        .description("메시지"),
                    fieldWithPath("data").type(JsonFieldType.OBJECT)
                        .description("응답 데이터"),
                    fieldWithPath("data.bankCode").type(JsonFieldType.STRING)
                        .description("입금할 은행 코드"),
                    fieldWithPath("data.accountNumber").type(JsonFieldType.STRING)
                        .description("입금할 계좌 번호"),
                    fieldWithPath("data.amount").type(JsonFieldType.NUMBER)
                        .description("금액"),
                    fieldWithPath("data.pwd").type(JsonFieldType.STRING)
                        .description("계좌 비밀번호"),
                    fieldWithPath("data.content").type(JsonFieldType.STRING)
                        .description("이체 내용"),
                    fieldWithPath("data.tradeDateTime").type(JsonFieldType.ARRAY)
                        .description("이체 시간")
                )
            ));
    }
}
