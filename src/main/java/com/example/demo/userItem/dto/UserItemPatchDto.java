package com.example.demo.userItem.dto;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class UserItemPatchDto {
    private Long userId;
    private Long itemId;
    private String daily;
    private BigDecimal amount;
}
