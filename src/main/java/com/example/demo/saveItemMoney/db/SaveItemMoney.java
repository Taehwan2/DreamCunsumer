package com.example.demo.saveItemMoney.db;


import com.example.demo.saveItemMoney.dto.SaveItemMoneyResponse;
import lombok.*;
import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.math.BigDecimal;

@Entity
@Table(name = "save_money")
@Setter
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SaveItemMoney {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "saveItemMoneyId",nullable = false,unique = true)
    private Long saveItemMoneyId;

    private Long userId;

    private Long itemId;

    private BigDecimal amount;

    public static SaveItemMoneyResponse EntityToResponseDto(SaveItemMoney saveItemMoney){
        return SaveItemMoneyResponse.builder()
                .saveItemMoneyId(saveItemMoney.getSaveItemMoneyId())
                .userId(saveItemMoney.getUserId())
                .itemId(saveItemMoney.getItemId())
                .amount(saveItemMoney.getAmount())
                .build();

    }
}
