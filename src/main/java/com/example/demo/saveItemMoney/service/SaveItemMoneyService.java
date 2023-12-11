package com.example.demo.saveItemMoney.service;

import com.example.demo.saveItemMoney.db.SaveItemMoney;
import com.example.demo.saveItemMoney.db.SaveItemMoneyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class SaveItemMoneyService {
    private final SaveItemMoneyRepository saveItemMoneyRepository;


    public SaveItemMoney enrollSaveItemMoney(SaveItemMoney saveItemMoney){
        return saveItemMoneyRepository.save(saveItemMoney);
    }
    public SaveItemMoney getOneById(Long id){
        return saveItemMoneyRepository.findById(id).orElseThrow(()->new NoSuchElementException("no element"));
    }

    public Optional<SaveItemMoney> getOneByIdAndUserId(Long userId, Long itemId){
        return saveItemMoneyRepository.findByIdAndUserId(userId,itemId);
    }


}
