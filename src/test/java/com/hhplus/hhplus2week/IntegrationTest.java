package com.hhplus.hhplus2week;

import com.hhplus.hhplus2week.specialClass.application.SpecialClassInventoryService;
import com.hhplus.hhplus2week.specialClass.application.SpecialClassItemService;
import com.hhplus.hhplus2week.specialClass.application.SpecialEnrolmentService;
import com.hhplus.hhplus2week.specialClass.domain.entity.SpecialClassInventory;
import com.hhplus.hhplus2week.specialClass.domain.entity.SpecialClassItem;
import com.hhplus.hhplus2week.specialClass.domain.entity.SpecialEnrolment;
import com.hhplus.hhplus2week.specialClass.facade.SpecialFacade;
import com.hhplus.hhplus2week.specialClass.facade.SpecialUserFacade;
import com.hhplus.hhplus2week.user.application.UserService;
import com.hhplus.hhplus2week.user.domain.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class IntegrationTest {

    @Autowired
    SpecialFacade specialFacade;

    @Autowired
    SpecialUserFacade specialUserFacade;

    @Autowired
    UserService userService;

    @Autowired
    SpecialClassItemService specialClassItemService;
    @Autowired
    private SpecialEnrolmentService specialEnrolmentService;
    @Autowired
    private SpecialClassInventoryService specialClassInventoryService;

    @Test
    void 신청_가능한_강의를_만든다() throws InterruptedException {
        String name = "강의 테스트!!!";
        String teacher = "선생님 이름";
        LocalDateTime date = LocalDateTime.of(2024, 8, 3, 0, 0, 0);
        LocalDateTime openDate = LocalDateTime.of(2024, 12, 30, 9, 0 ,0);

        specialFacade.saveInitAllSpecialClass(name, teacher, date, openDate);
    }

    @Test
    void 동시에_30명이_수강신청을_한다() throws InterruptedException {
        // given

        String name = "test";
        String mobile = "01011111111";
        User user = userService.saveUser(name, mobile);

        List<SpecialClassItem> SpecialClassItemList = specialFacade.getSpecialClassItemsAfterNow();
        long specialClassItemId = SpecialClassItemList.get(0).getId();

        specialUserFacade.enrolSpecialClass(user.getId(), specialClassItemId);

        int numberOfThreads = 100;
        ExecutorService executorService = Executors.newFixedThreadPool(32);
        CountDownLatch latch = new CountDownLatch(numberOfThreads);

        for (int i = 0; i < numberOfThreads; i++) {
            long userId = i + 1;
            executorService.submit(() -> {
                try {
                    specialFacade.saveUserSpecialClassEnrolment(userId, specialClassItemId);
                } catch (Exception e) {
                    // 예외 처리
                    e.printStackTrace();
                } finally {
                    latch.countDown();
                }
            });
        }

        latch.await();

        // then
        SpecialClassInventory inventory = specialClassInventoryService.getSpecialClassInventoryByItemId(specialClassItemId);
        assertThat(inventory.getCurrentHeadcount()).isEqualTo(30);
    }
}
