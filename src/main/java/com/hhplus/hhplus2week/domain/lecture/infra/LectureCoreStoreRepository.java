package com.hhplus.hhplus2week.domain.lecture.infra;

import com.hhplus.hhplus2week.domain.lecture.models.Lecture;
import com.hhplus.hhplus2week.domain.lecture.repositories.LectureStoreRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LectureCoreStoreRepository implements LectureStoreRepository {

    @Autowired
    LectureJpaRepository lectureJpaRepository;
    @Autowired
    LectureCustomRepository lectureCustomRepository;

    @Transactional
    @Override
    public Lecture save(Lecture lecture) {
        return lectureJpaRepository.save(lecture);
    }
}
