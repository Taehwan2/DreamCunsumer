package com.example.demo.userItem.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserItemResoponseDto {
    private Long id;

    private Long userId;

    private Long itemId;

    private Boolean isCommon = false;

    private BigDecimal amount ;

    private String daily;

    private BigDecimal dailyAmount ;
    private Long tagId;
}
