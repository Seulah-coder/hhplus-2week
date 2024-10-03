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

        String name = "test";
        long headCount = 20L;
        String teacher = "test teacher";
        SpecialClass specialClass = new SpecialClass();
        specialClass.setName(name);
        specialClass.setTeacher(teacher);


        when(specialClassRepository.save(any(SpecialClass.class))).thenReturn(specialClass);
        // Act
        SpecialClass result = specialClassService.saveSpecialClass(name, teacher);

        // Assert
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("test teacher", result.getName());
    }

    @Test
    void updateSpecialClass() {
    }

    @Test
    void getSpecialClass() {
        long classId = 1L;
        specialClassService.getSpecialClass(classId);
    }

    @Test
    void getSpecialClasses() {

    }
}