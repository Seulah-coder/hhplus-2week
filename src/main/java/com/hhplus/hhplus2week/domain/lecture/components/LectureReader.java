package com.hhplus.hhplus2week.domain.lecture.components;

import com.hhplus.hhplus2week.domain.lecture.infra.LectureCustomRepository;
import com.hhplus.hhplus2week.domain.lecture.infra.LectureJpaRepository;
import com.hhplus.hhplus2week.domain.lecture.models.Lecture;
import com.hhplus.hhplus2week.domain.lecture.repositories.LectureReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class LectureReader {
    @Autowired
    LectureReaderRepository lectureReaderRepository;


    public Lecture getLecture(Long lectureId){
        return lectureReaderRepository.read(lectureId);
    }

    public List<Lecture> getAllLecturesByDate(LocalDateTime date){
        return lectureReaderRepository.readLectures(date);
    }


}
