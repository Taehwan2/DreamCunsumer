package com.example.demo.tag.dto;

import lombok.*;

@Setter
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TagResponseDto {
    private Long tagId;

    private Long userId;

    private String tags;
}
