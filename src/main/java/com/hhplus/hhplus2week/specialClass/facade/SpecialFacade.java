package com.hhplus.hhplus2week.specialClass.facade;

import com.hhplus.hhplus2week.specialClass.HeadcountExceededException;
import com.hhplus.hhplus2week.specialClass.application.SpecialClassInventoryService;
import com.hhplus.hhplus2week.specialClass.application.SpecialClassItemService;
import com.hhplus.hhplus2week.specialClass.application.SpecialClassService;
import com.hhplus.hhplus2week.specialClass.application.SpecialEnrolmentService;
import com.hhplus.hhplus2week.specialClass.domain.entity.SpecialClass;
import com.hhplus.hhplus2week.specialClass.domain.entity.SpecialClassInventory;
import com.hhplus.hhplus2week.specialClass.domain.entity.SpecialClassItem;
import com.hhplus.hhplus2week.specialClass.domain.entity.SpecialEnrolment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class SpecialFacade {

    @Autowired
    SpecialClassItemService specialClassItemService;

    @Autowired
    SpecialClassInventoryService specialClassInventoryService;

    @Autowired
    SpecialClassService specialClassService;
    @Autowired
    private SpecialEnrolmentService specialEnrolmentService;

    /**
     * 초기 강의 등록 설정
     * @param name
     * @param teacher
     * @param openDate
     * @return
     */
    public SpecialClassInventory saveInitAllSpecialClass(String name, String teacher ,String openDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(openDate, formatter);
        long totalHeadcount = 30L;
        SpecialClass specialClass = specialClassService.saveSpecialClass(name, teacher);
        SpecialClassItem specialClassItem = specialClassItemService.saveSpecialClassItem(specialClass.getId(), localDateTime, totalHeadcount);
        SpecialClassInventory specialClassInventory = specialClassInventoryService.saveSpecialClassInventory(specialClass.getId(), specialClassItem.getId(), 0);;
        return specialClassInventory;
    }

    /**
     * 강의 정원이 totalHeadcount 이하인지 체크한다
     * @param itemId
     * @return
     */
    public boolean checkHeadCount(long itemId){
        SpecialClassItem item = specialClassItemService.getSpecialClassItem(itemId);
        SpecialClassInventory inventory = specialClassInventoryService.getSpecialClassInventoryByItemId(itemId);
        if(item.getTotalHeadcount() <= inventory.getCurrentHeadcount()){
            throw new HeadcountExceededException("전체 정원 오버로 신청 불가");
        }
        return true;
    }

    /**
     * 유저가 강의를 신청한다.
     * @param userId
     * @param itemId
     * @return
     */
    public SpecialEnrolment saveUserSpecialClassEnrolment(long userId, long itemId){
        SpecialEnrolment enrolment  = specialEnrolmentService.saveSpecialEnrolment(userId, itemId);
        SpecialClassInventory inventory = specialClassInventoryService.getSpecialClassInventoryByItemId(itemId);
        inventory.setCurrentHeadcount(inventory.getCurrentHeadcount() + 1);
        specialClassInventoryService.updateSpecialClassInventory(inventory);
        return enrolment;
    }

    /**
     * 현재 날짜 이후로 신청 가능한 강의 목록을 조회한다.
     * @return
     */
    public List<SpecialClassItem> getSpecialClassItemsAfterNow(){
        return specialClassItemService.getSpecialClassItemsAfterNow();
    }


}
