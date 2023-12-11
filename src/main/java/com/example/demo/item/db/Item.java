package com.example.demo.item.db;

import com.example.demo.item.dto.ItemResponseDto;

import lombok.*;
import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.math.BigDecimal;

@Entity
@Table(name = "item")
@Setter
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id",nullable = false,unique = true)
    private Long itemId;

    @Column(name = "name",nullable = true,unique = false)
    private String name;

    @Column(name = "price",nullable = true,unique = false)
    private BigDecimal price;

    public static ItemResponseDto EntityToResponseDto(Item item){
        return ItemResponseDto.builder()
                .itemId(item.getItemId())
                .name(item.getName())
                .price(item.getPrice())
                .build();

    }
}
