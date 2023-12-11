package com.example.demo.user.service;

import com.example.demo.user.db.UserRepository;
import com.example.demo.user.db.UserTable;
import com.example.demo.user.dto.UserResponseDto;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserService {

    private  final UserRepository userRepository;

    public UserTable enrollUser(UserTable user){
        log.info("user save method start:");
       return userRepository.save(user);
    }

}
