package com.hhplus.hhplus2week.specialClass.application;

import com.hhplus.hhplus2week.specialClass.domain.entity.SpecialClass;
import com.hhplus.hhplus2week.specialClass.persistence.SpecialClassRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialClassService {

    @Autowired
    SpecialClassRepository specialClassRepository;

    /**
     * 강의를 저장한다
     * @param name
     * @param headCount
     * @param teacher
     * @return
     */
    @Transactional
    public SpecialClass saveSpecialClass(String name, String teacher){
        SpecialClass specialClass = new SpecialClass();
        specialClass.setName(name);
        specialClass.setTeacher(teacher);
        specialClass = specialClassRepository.save(specialClass);
        return specialClass;
    }

    /**
     * 강의를 업데이트 한다
     * @param specialClass
     * @return
     */
    @Transactional
    public SpecialClass updateSpecialClass(SpecialClass specialClass){
        SpecialClass findSpecialClass = this.getSpecialClass(specialClass.getId());
        findSpecialClass.setTeacher(specialClass.getTeacher());
        findSpecialClass.setName(specialClass.getName());
        specialClassRepository.save(findSpecialClass);
        return findSpecialClass;
    }

    /**
     * 강의를 조회한다
     * @param classId
     * @return
     */
    public SpecialClass getSpecialClass(long classId){
        return specialClassRepository.findById(classId).orElseThrow(() -> new IllegalArgumentException("해당하는 강의 없음"));
    }

    /**
     * 강의들을 조회한다
     * @param name
     * @return
     */
    public List<SpecialClass> getSpecialClasses(String name){
        return specialClassRepository.findAllByName(name);
    }
}
