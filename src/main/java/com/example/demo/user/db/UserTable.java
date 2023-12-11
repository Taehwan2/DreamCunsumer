package com.example.demo.user.db;

import com.example.demo.user.dto.UserRequestDto;
import com.example.demo.user.dto.UserResponseDto;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "user_table")
@Setter
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id",nullable = false,unique = true)
    private Long userId;

    @Column(name = "name",nullable = true,unique = false)
    private String name;

    @Column(name = "age",nullable = true,unique = false)
    private int age;

    public static UserResponseDto EntityToResponseDto(UserTable userTable){
        return UserResponseDto.builder()
                .userId(userTable.getUserId())
                .age(userTable.getAge())
                .name(userTable.getName())
                .build();

    }
}

