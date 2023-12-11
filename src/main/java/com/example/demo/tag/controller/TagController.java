package com.example.demo.tag.controller;

import com.example.demo.tag.db.Tag;
import com.example.demo.tag.dto.TagRequestDto;
import com.example.demo.tag.service.TagService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/tag")
public class TagController {

    private final TagService tagService;

    @PostMapping()
    public ResponseEntity enrollTag(@RequestBody TagRequestDto tagRequestDto){
        Tag tag = tagService.enrollTag(TagRequestDto.requestDtoToEntity(tagRequestDto));
        return new ResponseEntity(Tag.EntityToResponseDto(tag), HttpStatus.CREATED);
    }

}
