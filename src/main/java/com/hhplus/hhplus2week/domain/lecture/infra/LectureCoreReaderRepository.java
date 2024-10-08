package com.hhplus.hhplus2week.domain.lecture.infra;

import com.hhplus.hhplus2week.domain.lecture.models.Lecture;
import com.hhplus.hhplus2week.domain.lecture.repositories.LectureReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class LectureCoreReaderRepository implements LectureReaderRepository {

    @Autowired
    LectureJpaRepository lectureJpaRepository;

    @Autowired
    LectureCustomRepository lectureCustomRepository;

    @Override
    public Lecture read(Long id) {
        return lectureJpaRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Lecture> readLectures(LocalDateTime date) {
        return lectureJpaRepository.findLectureItemsAfterTheDate(date);
    }

}
