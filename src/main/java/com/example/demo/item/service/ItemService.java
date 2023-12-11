package com.example.demo.item.service;

import com.example.demo.item.db.Item;
import com.example.demo.item.db.ItemRepository;
import com.example.demo.user.db.UserTable;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class ItemService {

    private final ItemRepository repository;

    public Item enrollUser(Item item){
        log.info("item save method start:");
        return repository.save(item);
    }
}
