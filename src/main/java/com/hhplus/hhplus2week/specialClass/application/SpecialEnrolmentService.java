package com.hhplus.hhplus2week.specialClass.application;

import com.hhplus.hhplus2week.specialClass.domain.entity.SpecialEnrolment;
import com.hhplus.hhplus2week.specialClass.persistence.SpecialEnrolmentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialEnrolmentService {

    @Autowired
    SpecialEnrolmentRepository specialEnrolmentRepository;

    @Transactional
    public SpecialEnrolment saveSpecialEnrolment(long userId, long itemId){
        SpecialEnrolment specialEnrolment = new SpecialEnrolment();
        specialEnrolment.setUserId(userId);
        specialEnrolment.setClassItemId(itemId);
        specialEnrolment.setEnrolTime(System.currentTimeMillis());
        specialEnrolmentRepository.save(specialEnrolment);
        return specialEnrolment;
    }

    /**
     * 유저 아이디로 강의 신청한 내역을 조회한다.
     * @param userId
     * @return
     */
    public List<SpecialEnrolment> getSpecialEnrolments(long userId){
        return specialEnrolmentRepository.findSpecialEnrolmentsByUserId(userId);
    }
}
