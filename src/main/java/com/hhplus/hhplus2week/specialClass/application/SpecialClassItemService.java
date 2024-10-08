package com.hhplus.hhplus2week.specialClass.application;

import com.hhplus.hhplus2week.specialClass.domain.entity.SpecialClassItem;
import com.hhplus.hhplus2week.specialClass.persistence.SpecialClassItemRepository;
import jakarta.persistence.LockModeType;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SpecialClassItemService {
    @Autowired
    SpecialClassItemRepository specialClassItemRepository;

    /**
     * 강의의 세부 사항을 저장한다
     * @param classId
     * @param date
     * @return
     */
    @Transactional
    public SpecialClassItem saveSpecialClassItem(long classId, LocalDateTime date, long totalHeadcount){
        SpecialClassItem specialClassItem = new SpecialClassItem();
        specialClassItem.setClassId(classId);
        specialClassItem.setOpenDate(date);
        specialClassItem.setTotalHeadcount(totalHeadcount);
        specialClassItem = specialClassItemRepository.save(specialClassItem);
        return specialClassItem;
    }

    @Transactional
    public SpecialClassItem updateSpecialClassItem(SpecialClassItem specialClassItem){
        SpecialClassItem findSpecialClassItem = this.getSpecialClassItem(specialClassItem.getId());
        findSpecialClassItem.setOpenDate(specialClassItem.getOpenDate());
        findSpecialClassItem.setTotalHeadcount(specialClassItem.getTotalHeadcount());
        findSpecialClassItem.setClassId(specialClassItem.getClassId());
        return findSpecialClassItem;
    }

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    public SpecialClassItem getSpecialClassItem(long itemId){
        return specialClassItemRepository.findById(itemId).orElseThrow(() -> new IllegalArgumentException("강의 아이디 없음"));
    }

    public List<SpecialClassItem> getAllSpecialClassItems(){
        return specialClassItemRepository.findAll();
    }

    public List<SpecialClassItem> getSpecialClassItems(long classId){
        return specialClassItemRepository.findAllByClassId(classId);
    }

    public List<SpecialClassItem> getSpecialClassItemsAfterNow(){
        LocalDateTime date = LocalDateTime.now();
        return specialClassItemRepository.findSpecialItemsAfterTheDate(date);
    }


}
