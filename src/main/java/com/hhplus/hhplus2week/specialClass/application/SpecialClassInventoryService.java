package com.hhplus.hhplus2week.specialClass.application;

import com.hhplus.hhplus2week.specialClass.domain.entity.SpecialClassInventory;
import com.hhplus.hhplus2week.specialClass.domain.entity.SpecialClassItem;
import com.hhplus.hhplus2week.specialClass.persistence.SpecialClassInventoryRepository;
import com.hhplus.hhplus2week.specialClass.persistence.SpecialClassRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;

@Service
public class SpecialClassInventoryService {
    @Autowired
    SpecialClassInventoryRepository specialClassInventoryRepository;

    @Autowired
    SpecialClassItemService specialClassItemService;
    @Autowired
    private SpecialClassRepository specialClassRepository;

    @Transactional
    public SpecialClassInventory saveSpecialClassInventory(long itemId, long classId, long headcount, LocalDateTime date){
        SpecialClassInventory specialClassInventory = new SpecialClassInventory();
        specialClassInventory.setSpecialClassItemId(itemId);
        specialClassInventory.setClassId(classId);
        specialClassInventory.setCurrentHeadcount(headcount);
        specialClassInventory.setOpenDate(date);
        specialClassInventory = specialClassInventoryRepository.save(specialClassInventory);
        return specialClassInventory;
    }

    @Transactional
    public SpecialClassInventory updateSpecialClassInventory(SpecialClassInventory specialClassInventory){
        SpecialClassInventory findSpecialClassInventory = this.getSpecialClassInventory(specialClassInventory.getId());

        SpecialClassItem specialClassItem = specialClassItemService.getSpecialClassItem(findSpecialClassInventory.getClassId());
        if(specialClassItem.getTotalHeadcount() < findSpecialClassInventory.getCurrentHeadcount()){
            throw new RejectedExecutionException("전체 정원 오버");
        }
        findSpecialClassInventory.setOpenDate(specialClassInventory.getOpenDate());
        findSpecialClassInventory.setCurrentHeadcount(specialClassInventory.getCurrentHeadcount());
        findSpecialClassInventory.setClassId(specialClassInventory.getClassId());
        findSpecialClassInventory.setSpecialClassItemId(specialClassInventory.getSpecialClassItemId());
        return findSpecialClassInventory;
    }

    public SpecialClassInventory getSpecialClassInventory(long id){
        return specialClassInventoryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("강의 인벤토리 없음"));
    }

    public List<SpecialClassInventory> getSpecialClassInventoriesByClassId(long classId){
        return specialClassInventoryRepository.findAllByClassId(classId);
    }

    public List<SpecialClassInventory> getSpecialClassInventoriesByItemId(long itemId){
        return specialClassInventoryRepository.findAllBySpecialClassItemId(itemId);
    }
}
