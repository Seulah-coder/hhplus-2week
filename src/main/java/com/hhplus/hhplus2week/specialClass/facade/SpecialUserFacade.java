package com.hhplus.hhplus2week.specialClass.facade;

import com.hhplus.hhplus2week.specialClass.application.SpecialClassService;
import com.hhplus.hhplus2week.user.application.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SpecialUserFacade {

    @Autowired
    SpecialClassService specialClassService;

    @Autowired
    UserService userService;

}
