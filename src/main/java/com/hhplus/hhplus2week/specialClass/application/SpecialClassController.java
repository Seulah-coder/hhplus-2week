package com.hhplus.hhplus2week.specialClass.application;

import com.hhplus.hhplus2week.specialClass.domain.entity.SpecialClassInventory;
import com.hhplus.hhplus2week.specialClass.domain.entity.SpecialClassItem;
import com.hhplus.hhplus2week.specialClass.domain.entity.SpecialEnrolment;
import com.hhplus.hhplus2week.specialClass.facade.SpecialFacade;
import com.hhplus.hhplus2week.specialClass.facade.SpecialUserFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/specialClass")
public class SpecialClassController {

    private final SpecialFacade specialFacade;
    private final SpecialUserFacade specialUserFacade;


    public SpecialClassController(SpecialFacade specialFacade, SpecialUserFacade specialUserFacade) {
        this.specialFacade = specialFacade;
        this.specialUserFacade = specialUserFacade;
    }

    /**
     * 특강 생성
     * @param params
     * @return
     */
    @PostMapping("/create")
    public ResponseEntity<SpecialClassInventory> createSpecialClass(Map<String, Objects> params){
        SpecialClassInventory inventory = specialFacade.saveInitAllSpecialClass(params.get("name").toString(), params.get("teacher").toString(), params.get("openDate").toString());
        return ResponseEntity.ok(inventory);
    }

    /**
     * 오늘 날짜 이후 특강 조회
     * @return
     */
    @GetMapping("/list")
    public ResponseEntity<List<SpecialClassItem>> getSpecialClassList(){
        List<SpecialClassItem> itemList = specialFacade.getSpecialClassItemsAfterNow();
        return ResponseEntity.ok(itemList);
    }

    /**
     * 유저가 신청한 특강 조회
     * @param userId
     * @return
     */
    @GetMapping("/fetchlist/{id}")
    public ResponseEntity<List<SpecialEnrolment>> getSpecialEnrolments(@PathVariable("id") long userId){
        List<SpecialEnrolment> enrolments = specialUserFacade.getSpecialEnrolments(userId);
        return ResponseEntity.ok(enrolments);
    }

    /**
     * API Specs 특강 신청
     * @param userId
     * @param itemId
     * @return
     */
    @GetMapping("/enrolUser/{userId}/{itemId}}")
    public ResponseEntity<SpecialEnrolment> enrolSpecialClass(@PathVariable("userId")long userId, @PathVariable("itemId") long itemId){
        SpecialEnrolment enrolment = specialFacade.saveUserSpecialClassEnrolment(userId, itemId);
        return ResponseEntity.ok(enrolment);
    };

}
