package com.example.demo.saveItemMoney.dto;

import lombok.*;

import java.math.BigDecimal;

@Setter
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SaveItemMoneyResponse {
    private Long saveItemMoneyId;

    private Long userId;

    private Long itemId;

    private BigDecimal amount;

}
