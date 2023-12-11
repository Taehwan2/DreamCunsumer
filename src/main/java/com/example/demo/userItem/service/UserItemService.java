package com.example.demo.userItem.service;

import com.example.demo.userItem.db.UserItem;
import com.example.demo.userItem.db.UserItemRepository;
import com.example.demo.userItem.dto.UserItemPatchDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserItemService {
    private final UserItemRepository userItemRepository;
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public UserItem enrollUserItem(UserItem userItem){
        userItem.setIsCommon(false);
        userItem.setDaily("");
        applicationEventPublisher.publishEvent(userItem.publish());
        return userItemRepository.saveAndFlush(userItem);
    }

    public UserItem saveUserItem(UserItem userItem){
        applicationEventPublisher.publishEvent(userItem.publish());
        return userItemRepository.save(userItem);
    }

    public List<UserItem> findByTagId(Long tagId){
        return userItemRepository.findByTagIdAndAmountIsNull(tagId).orElseThrow(()->new NoSuchElementException("no elemnet"));
    }
    public UserItem changeDailyMoney(UserItemPatchDto userItemPatchDto){
       UserItem userItem =  userItemRepository.findByIdAndUserIdAndAmountIsNull(userItemPatchDto.getUserId(),userItemPatchDto.getItemId()).orElseThrow(()-> new NoSuchElementException("NO Elitemt"));
       userItem.setDaily(userItemPatchDto.getDaily());
       userItem.setDailyAmount(userItemPatchDto.getAmount());
      return userItemRepository.save(userItem);
    }

    public List<UserItem> findDailyIsNotNull(){
       return userItemRepository.findDailyIsNotEmpty();
    }
}
