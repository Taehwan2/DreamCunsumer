package com.example.demo.user.dto;

import com.example.demo.user.db.UserTable;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {

    private String name;

    private int age;

    public static UserTable requestDtoToEntity(UserRequestDto userRequestDto){
       return UserTable.builder()
                .age(userRequestDto.getAge())
                .name(userRequestDto.getName())
                .build();

    }
}
