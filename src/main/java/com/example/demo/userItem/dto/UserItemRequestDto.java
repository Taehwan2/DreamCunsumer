package com.example.demo.userItem.dto;

import com.example.demo.user.db.UserTable;
import com.example.demo.user.dto.UserRequestDto;
import com.example.demo.userItem.db.UserItem;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserItemRequestDto {

    private Long userId;

    private Long itemId;

    private BigDecimal amount;

    private Long tagId;

    public static UserItem requestDtoToEntity(UserItemRequestDto userRequestDto){
        return UserItem.builder()
                .userId(userRequestDto.getUserId())
                .itemId(userRequestDto.getItemId())
                .amount(userRequestDto.getAmount())
                .tagId(userRequestDto.getTagId())
                .build();

    }
}
