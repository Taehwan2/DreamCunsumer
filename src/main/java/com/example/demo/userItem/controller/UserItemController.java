package com.example.demo.userItem.controller;


import com.example.demo.userItem.db.UserItem;
import com.example.demo.userItem.dto.UserItemPatchDto;
import com.example.demo.userItem.dto.UserItemRequestDto;
import com.example.demo.userItem.dto.UserItemResoponseDto;
import com.example.demo.userItem.service.UserItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/userItem")
public class UserItemController {
private final UserItemService userItemService;

    @PostMapping()
    public ResponseEntity enrollUserItem(@RequestBody UserItemRequestDto userItemRequestDto){
        log.info("enrollUserItem exec");
        UserItem userItem = userItemService.enrollUserItem(UserItemRequestDto.requestDtoToEntity(userItemRequestDto));
        return new ResponseEntity<>(UserItem.EntityToResponseDto(userItem), HttpStatus.CREATED);

    }
    @PatchMapping()
    public ResponseEntity updateUserItem(@RequestBody UserItemPatchDto userItemPatchDto){
        log.info("enrollUserItem exec");
        UserItem userItem = userItemService.changeDailyMoney(userItemPatchDto);
        return new ResponseEntity<>(UserItem.EntityToResponseDto(userItem), HttpStatus.CREATED);

    }
    @GetMapping("/{tagId}")
    public ResponseEntity getByTagId(@PathVariable(name = "tagId")Long tagId){
        log.info("getByTagId exec");
        List<UserItem> userItem = userItemService.findByTagId(tagId);
        return new ResponseEntity<>(userItem, HttpStatus.CREATED);

    }
}
