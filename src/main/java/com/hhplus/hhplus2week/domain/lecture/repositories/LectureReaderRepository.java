package com.hhplus.hhplus2week.domain.lecture.repositories;

import com.hhplus.hhplus2week.domain.lecture.models.Lecture;

import java.time.LocalDateTime;
import java.util.List;

public interface LectureReaderRepository {

    Lecture read(Long id);

    List<Lecture> readLectures(LocalDateTime date);
}
