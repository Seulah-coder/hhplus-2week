package com.hhplus.hhplus2week.specialClass.facade;

import com.hhplus.hhplus2week.specialClass.application.SpecialClassInventoryService;
import com.hhplus.hhplus2week.specialClass.application.SpecialClassItemService;
import com.hhplus.hhplus2week.specialClass.application.SpecialClassService;
import com.hhplus.hhplus2week.specialClass.domain.entity.SpecialClass;
import com.hhplus.hhplus2week.specialClass.domain.entity.SpecialClassInventory;
import com.hhplus.hhplus2week.specialClass.domain.entity.SpecialClassItem;
import com.hhplus.hhplus2week.user.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class SpecialFacade {

    @Autowired
    SpecialClassItemService specialClassItemService;

    @Autowired
    SpecialClassInventoryService specialClassInventoryService;

    @Autowired
    SpecialClassService specialClassService;

    public void saveAllSpecialClass(String name, String teacher) {
        SpecialClass specialClass = specialClassService.saveSpecialClass(name, teacher);
        SpecialClassItem specialClassItem = specialClassItemService.saveSpecialClassItem()

    }


}
