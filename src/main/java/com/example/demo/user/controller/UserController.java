package com.example.demo.user.controller;

import com.example.demo.user.db.UserTable;
import com.example.demo.user.dto.UserRequestDto;
import com.example.demo.user.service.UserService;
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
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping()
    public ResponseEntity enrollUser(@RequestBody UserRequestDto userRequestDto){
        log.info("enrollUser method exec");
        UserTable userTable = userService.enrollUser(UserRequestDto.requestDtoToEntity(userRequestDto));
        log.info("user Service enrollUser exec:");
        log.info("user Service enrollUser return : {}",userTable.toString());
        return  new ResponseEntity(UserTable.EntityToResponseDto(userTable), HttpStatus.CREATED);
    }
}
