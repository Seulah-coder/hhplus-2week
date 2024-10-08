package com.hhplus.hhplus2week.domain.lecture.components;

import com.hhplus.hhplus2week.api.lecture.dto.LectureDTO;
import com.hhplus.hhplus2week.domain.lecture.infra.LectureJpaRepository;
import com.hhplus.hhplus2week.domain.lecture.models.Lecture;
import com.hhplus.hhplus2week.domain.lecture.repositories.LectureStoreRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LectureModifier {

    @Autowired
    LectureStoreRepository lectureStoreRepository;

    @Transactional
    public Lecture saveLecture(LectureDTO lectureDTO){
        Lecture lecture = Lecture.builder()
                .id(null)
                .name(lectureDTO.getName())
                .teacher(lectureDTO.getTeacher())
                .build();

        return lectureStoreRepository.save(lecture);
    }

    @Transactional
    public Lecture updateLecture(LectureDTO lectureDTO){
        Lecture lecture = Lecture.builder()
                .id(lectureDTO.getId())
                .name(lectureDTO.getName())
                .teacher(lectureDTO.getTeacher())
                .build();

        return lectureStoreRepository.save(lecture);
    }
}
