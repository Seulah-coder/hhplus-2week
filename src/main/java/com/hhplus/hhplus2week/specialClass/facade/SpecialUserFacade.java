package com.hhplus.hhplus2week.specialClass.facade;

import com.hhplus.hhplus2week.specialClass.application.SpecialClassInventoryService;
import com.hhplus.hhplus2week.specialClass.application.SpecialEnrolmentService;
import com.hhplus.hhplus2week.specialClass.domain.entity.SpecialEnrolment;
import com.hhplus.hhplus2week.user.application.UserService;
import com.hhplus.hhplus2week.user.domain.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SpecialUserFacade {

    @Autowired
    SpecialFacade specialFacade;

    @Autowired
    UserService userService;

    @Autowired
    SpecialEnrolmentService specialEnrolmentService;

    /**
     * 유저가 강의를 신청한다
     * @param userId
     * @param itemId
     */
    @Transactional
    public void enrolSpecialClass(long userId, long itemId){
        try {
            User user = userService.getUser(userId);
            if(user != null){
                boolean checkResult = specialFacade.checkHeadCount(itemId);
                if(checkResult){
                    specialFacade.saveUserSpecialClassEnrolment(userId, itemId);
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 유저 아이디로 신청한 강의를 조회한다
     * @param userId
     * @return
     */
    public List<SpecialEnrolment> getSpecialEnrolments(long userId){
        return specialEnrolmentService.getSpecialEnrolments(userId);
    }
}
