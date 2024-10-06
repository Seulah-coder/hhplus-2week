package com.hhplus.hhplus2week.user;

import com.hhplus.hhplus2week.user.application.UserService;
import com.hhplus.hhplus2week.user.domain.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UserIntegrationTest {

    @Autowired
    UserService userService;

    @Test
    void saveUser(){
        String userName = "testUser";
        String mobile = "01012345678";

        User result = userService.createUser(userName, mobile);
        System.out.println("result = " + result);
        System.out.println("result = " + result.getId());
        System.out.println("result = " + result.getMobile());
    }
}
