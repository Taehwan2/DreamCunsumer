package com.example.demo.userItemAndUser.service;

import com.example.demo.user.db.UserRepository;
import com.example.demo.user.db.UserTable;
import com.example.demo.userItem.db.UserItem;
import com.example.demo.userItem.db.UserItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserAndUserItemService {
    private final UserItemRepository userItemRepository;
    private final UserRepository userRepository;

    public List<String> getCommonItemUser(Long id){
        List<UserItem> userItems = userItemRepository.findByItemIdAndAmountIsNull(id).orElseThrow(()->new NoSuchElementException("noman"));
        List<String> userName=new ArrayList<>();
        for(UserItem  userItem: userItems){
            UserTable user = userRepository.findById(userItem.getUserId()).orElseThrow(()->new NoSuchElementException("noman"));
            userName.add(user.getName());
        }
        return userName;
    }
}
