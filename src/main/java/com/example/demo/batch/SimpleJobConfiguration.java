    package com.example.demo.batch;

    import com.example.demo.userItem.db.UserItemRepository;
    import com.example.demo.userItem.service.UserItemService;
    import lombok.RequiredArgsConstructor;
    import lombok.extern.slf4j.Slf4j;
    import org.springframework.batch.core.Job;
    import org.springframework.batch.core.Step;
    import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
    import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;

    @Slf4j
    @RequiredArgsConstructor
    @Configuration
    public class SimpleJobConfiguration {
        private final JobBuilderFactory jobBuilderFactory;
        private final StepBuilderFactory stepBuilderFactory;
        private final UserItemService userItemService;

        @Bean
        public Job changeItemMoney() {
            return jobBuilderFactory.get("changeItemMoney")
                    .start(changDailyMoney())
                    .on("FAILED")
                    .stopAndRestart(changDailyMoney())
                    .on("*")
                    .end()
                    .end()
                    .build();
        }

        @Bean
        public Step changDailyMoney() {
            return stepBuilderFactory.get("changDailyMoney")
                    .tasklet(new MoneyTasklet(userItemService))
                    .build();
        }
    }