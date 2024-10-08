package com.hhplus.hhplus2week.domain.lecture.infra;

import com.hhplus.hhplus2week.domain.lecture.models.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface LectureJpaRepository extends JpaRepository<Lecture, Long> {

    @Query("SELECT i FROM LectureSchedule i WHERE i.openDate > :date")
    List<Lecture> findLectureItemsAfterTheDate(@Param("date") LocalDateTime date);
}
