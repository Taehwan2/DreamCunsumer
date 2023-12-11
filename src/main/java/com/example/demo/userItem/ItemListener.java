package com.example.demo.userItem;

import com.example.demo.saveItemMoney.db.SaveItemMoney;
import com.example.demo.saveItemMoney.service.SaveItemMoneyService;
import com.example.demo.userItem.db.UserItem;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ItemListener {

    @Autowired
    private final SaveItemMoneyService itemMoneyService;

    @EventListener
    public void onApplicationEvent(ItemPublisher event) {
        System.out.println("------------------------");
        UserItem userItem = event.getUserItem();
        Optional<SaveItemMoney> opSaveItemMoney =itemMoneyService.getOneByIdAndUserId(userItem.getUserId(), userItem.getItemId());
        if(opSaveItemMoney.isEmpty()){
            itemMoneyService.enrollSaveItemMoney(SaveItemMoney.builder()
                            .userId(userItem.getUserId())
                            .itemId(userItem.getItemId())
                            .amount(userItem.getAmount())
                            .build());
        }else{
            SaveItemMoney saveItemMoney = opSaveItemMoney.get();
            BigDecimal newAmount = Optional.ofNullable(saveItemMoney.getAmount())
                    .orElse(BigDecimal.ZERO)
                    .add(userItem.getAmount());

            // setAmount() 호출
            saveItemMoney.setAmount(newAmount);
            itemMoneyService.enrollSaveItemMoney(saveItemMoney);
        }
        System.out.println("------------------------");

    }
}
