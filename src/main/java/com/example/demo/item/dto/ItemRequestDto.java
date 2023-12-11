package com.example.demo.item.dto;


import com.example.demo.item.db.Item;
import com.example.demo.user.db.UserTable;
import com.example.demo.user.dto.UserRequestDto;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemRequestDto {

    private String name;

    private BigDecimal price;


    public static Item requestDtoToEntity(ItemRequestDto itemRequestDto){
        return Item.builder()
                .price(itemRequestDto.getPrice())
                .name(itemRequestDto.getName())
                .build();

    }
}
