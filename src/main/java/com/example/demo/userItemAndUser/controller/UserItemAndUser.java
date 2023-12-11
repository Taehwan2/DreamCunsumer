package com.example.demo.userItemAndUser.controller;

import com.example.demo.userItem.db.UserItem;
import com.example.demo.userItemAndUser.service.UserAndUserItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/userItemAndUser")
public class UserItemAndUser {

    private final UserAndUserItemService userItemService;
    @GetMapping("/{itemId}")
    public ResponseEntity getByTagId(@PathVariable(name = "itemId")Long itemId){
        log.info("getByTagId exec");
        List<String> userName = userItemService.getCommonItemUser(itemId);
        return new ResponseEntity<>(userName, HttpStatus.CREATED);

    }
}
