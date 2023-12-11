package com.example.demo.batch;

import com.example.demo.userItem.db.UserItem;
import com.example.demo.userItem.db.UserItemRepository;
import com.example.demo.userItem.service.UserItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import java.awt.print.Book;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class MoneyTasklet implements Tasklet {
    private final UserItemService userItemService;
    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

        log.info("=====Start Change Board Status======");
        List<UserItem> userItemList =userItemService.findDailyIsNotNull();

        if(userItemList == null || userItemList.isEmpty()) {
            log.info("=====변경할 아이템이 없습니다.=====");
        } else {
            for(UserItem userItem : userItemList) {
                String daily = userItem.getDaily();
                System.out.println(daily);
                if(daily.equals("일")){
                    userItemService.saveUserItem(UserItem.builder()
                            .userId(userItem.getUserId())
                            .itemId(userItem.getItemId())
                            .tagId(userItem.getTagId())
                            .amount(userItem.getDailyAmount())
                            .isCommon(userItem.getIsCommon())
                            .daily("")
                            .build());
                }
                else if(daily.equals("주")){
                    // 현재 날짜를 얻고, 오늘이 일요일인지 확인
                    if (LocalDate.now().getDayOfWeek() == DayOfWeek.SUNDAY) {
                        userItemService.saveUserItem(UserItem.builder()
                                .userId(userItem.getUserId())
                                .itemId(userItem.getItemId())
                                .tagId(userItem.getTagId())
                                .amount(userItem.getDailyAmount())
                                .isCommon(userItem.getIsCommon())
                                .daily("")
                                .build());
                    }
                }
                else if(daily.equals("월")){
                    // 현재 날짜를 얻고, 오늘이 1일인지 확인
                    if (LocalDate.now().getDayOfMonth() == 1) {
                        userItemService.saveUserItem(UserItem.builder()
                                .userId(userItem.getUserId())
                                .itemId(userItem.getItemId())
                                .tagId(userItem.getTagId())
                                .amount(userItem.getDailyAmount())
                                .isCommon(userItem.getIsCommon())
                                .daily("")
                                .build());
                    }
                }else{
                    throw new Exception("잘못된 형식입니다.");
                }

            }
        }
        log.info("=====End Change Board Status======");
        return RepeatStatus.FINISHED;
    }
}
