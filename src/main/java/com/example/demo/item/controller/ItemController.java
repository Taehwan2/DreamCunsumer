package com.example.demo.item.controller;

import com.example.demo.item.db.Item;
import com.example.demo.item.dto.ItemRequestDto;
import com.example.demo.item.service.ItemService;
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
@RequestMapping("/item")
public class ItemController {

    private final ItemService itemService;
    @PostMapping()
    public ResponseEntity enrollItem(@RequestBody ItemRequestDto itemRequestDto) {
        log.info("enrollItem exec");
       Item item = itemService.enrollUser(ItemRequestDto.requestDtoToEntity(itemRequestDto));
       return new ResponseEntity(Item.EntityToResponseDto(item) , HttpStatus.CREATED);
    }

}
