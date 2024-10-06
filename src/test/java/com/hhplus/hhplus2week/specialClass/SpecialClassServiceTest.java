package com.hhplus.hhplus2week.specialClass;

import com.hhplus.hhplus2week.specialClass.application.SpecialClassService;
import com.hhplus.hhplus2week.specialClass.domain.entity.SpecialClass;
import com.hhplus.hhplus2week.specialClass.persistence.SpecialClassRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class SpecialClassServiceTest {

    @InjectMocks
    SpecialClassService specialClassService;

    @MockBean
    SpecialClassRepository specialClassRepository;


    @Test
    void saveSpecialClass() {

        //given
        String name = "test";
        String teacher = "test teacher";
        SpecialClass specialClass = new SpecialClass();
        specialClass.setName(name);
        specialClass.setTeacher(teacher);

        //when
        when(specialClassRepository.save(any(SpecialClass.class))).thenReturn(specialClass);
        SpecialClass result = specialClassService.saveSpecialClass(name, teacher);

        //then
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("test teacher", result.getName());
    }

    @Test
    void updateSpecialClass() {

        //given
        Long specialClassId = 1L;
        SpecialClass specialClass = specialClassService.getSpecialClass(specialClassId);
        specialClass.setName("이름 바꿈");
        specialClass.setTeacher("선생님도 이름 바꿈");

        //when
        when(specialClassRepository.save(any(SpecialClass.class))).thenReturn(specialClass);
        SpecialClass result = specialClassService.updateSpecialClass(specialClass);

        //then
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("이름 바꿈", result.getName());
        assertEquals("선생님도 이름 바꿈", result.getTeacher());
    }

    @Test
    void getSpecialClass() {

        //given
        long classId = 1L;
        //when
        SpecialClass specialClass = specialClassService.getSpecialClass(classId);
        //then
        assertEquals(classId, specialClass.getId());

    }

}