package com.hhplus.hhplus2week.domain.lecture.repositories;

import com.hhplus.hhplus2week.domain.lecture.models.Lecture;
import org.springframework.stereotype.Repository;

@Repository
public interface LectureStoreRepository {

    Lecture save(Lecture lecture);
}
