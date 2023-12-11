package com.example.demo.item.dto;


import lombok.*;

import java.math.BigDecimal;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemResponseDto {

    private Long itemId;

    private String name;

    private BigDecimal price;
}
