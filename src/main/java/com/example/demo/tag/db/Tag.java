package com.example.demo.tag.db;

import com.example.demo.tag.dto.TagResponseDto;
import com.example.demo.user.db.UserTable;
import com.example.demo.user.dto.UserResponseDto;
import lombok.*;
import javax.persistence.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "tag")
@Setter
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tagId",nullable = false,unique = true)
    private Long tagId;

    private Long userId;

    private String tags;

    public static TagResponseDto EntityToResponseDto(Tag tag){
        return TagResponseDto.builder()
                .userId(tag.getUserId())
                .tagId(tag.getTagId())
                .tags(tag.getTags())
                .build();

    }
}
