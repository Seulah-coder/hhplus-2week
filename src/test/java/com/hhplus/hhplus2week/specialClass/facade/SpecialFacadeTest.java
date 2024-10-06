package com.hhplus.hhplus2week.specialClass.facade;

import com.hhplus.hhplus2week.specialClass.application.SpecialClassService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class SpecialFacadeTest {

    @InjectMocks
    SpecialFacade specialFacade;

    @MockBean
    SpecialClassService specialClassService;

    @Test
    void saveInitAllSpecialClass() {
        String name = "강의 테스트!!!";
        String teacher = "선생님 이름";
        LocalDateTime date = LocalDateTime.of(2024, 8, 3, 0, 0, 0);
        LocalDateTime openDate = LocalDateTime.of(2024, 12, 30, 9, 0 ,0);
        specialFacade.saveInitAllSpecialClass(name, teacher, date, openDate);
    }

    @Test
    void checkHeadCount() {
        long itemId = 1L;
        specialFacade.checkHeadCount(itemId);
    }

    @Test
    void getSpecialClassItemsAfterNow() {
        specialFacade.getSpecialClassItemsAfterNow();
    }
}