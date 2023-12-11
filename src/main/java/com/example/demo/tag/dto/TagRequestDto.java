package com.example.demo.tag.dto;

import com.example.demo.tag.db.Tag;
import com.example.demo.user.db.UserTable;
import com.example.demo.user.dto.UserRequestDto;
import lombok.*;

@Setter
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TagRequestDto {


    private Long userId;

    private String tags;

    public static Tag requestDtoToEntity(TagRequestDto tagRequestDto){
        return Tag.builder()
                .userId(tagRequestDto.getUserId())
                .tags(tagRequestDto.getTags())
                .build();

    }

}
