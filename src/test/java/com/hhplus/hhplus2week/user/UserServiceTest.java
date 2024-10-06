package com.hhplus.hhplus2week.user;

import com.hhplus.hhplus2week.user.application.UserService;
import com.hhplus.hhplus2week.user.domain.entity.User;
import com.hhplus.hhplus2week.user.persistence.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    UserService userService;

    @Mock
    UserRepository userRepository;


    @Test
    void saveUser() {

        //given
        String userName = "testUser";
        String mobile = "12345678";

        User user = new User();
        user.setId(1L);
        user.setName(userName);
        user.setMobile(mobile);

        when(userRepository.save(any(User.class))).thenReturn(user);
        // Act
        User result = userService.createUser(userName, mobile);

        // Assert
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("testUser", result.getName());

    }

}