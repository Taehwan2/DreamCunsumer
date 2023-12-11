package com.example.demo.userItem.db;

import com.example.demo.userItem.ItemPublisher;
import com.example.demo.userItem.dto.UserItemResoponseDto;
import lombok.*;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "UserItem")
@Setter
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserItem extends AbstractAggregateRoot<UserItem> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false,unique = true)
    private Long id;

    @Column(name = "user_id",nullable = false,unique = false)
    private Long userId;

    @Column(name = "item_id",nullable = false,unique = false)
    private Long itemId;

    @Column(name = "isCommon",nullable = false,unique = false)
    private Boolean isCommon = false;

    @Column(name = "amount",nullable = true,unique = false)
    private BigDecimal amount;

    @Column(name = "daily",nullable = false,unique = false)
    private String daily = "";

    @Column(name = "dailyAmount",nullable = true,unique = false)
    private BigDecimal dailyAmount;

    @Column(name = "tagId",nullable = false,unique = false)
    private Long tagId;

    public UserItem publish(){
        this.registerEvent(new ItemPublisher((this)));
        return this;
    }

    public static UserItemResoponseDto EntityToResponseDto(UserItem userItem){
        return UserItemResoponseDto.builder()
                .id(userItem.getId())
                .itemId(userItem.getItemId())
                .userId(userItem.getUserId())
                .isCommon(userItem.getIsCommon())
                .amount(userItem.getAmount())
                .daily(userItem.getDaily())
                .dailyAmount(userItem.getDailyAmount())
                .tagId(userItem.getTagId())
                .build();

    }


}
