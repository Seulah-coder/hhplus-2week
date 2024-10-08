package com.hhplus.hhplus2week.domain.lecture.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "TB_LECTURE_SCHEDULE")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LectureSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long Id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LECTURE_ID", nullable = false)
    private Lecture lecture;

    @Column(name = "HEADCOUNT", nullable = false)
    @ColumnDefault("30")
    private int headcount;

    @Column(name = "OPEN_DATE")
    private LocalDateTime openDate;

    @OneToMany(mappedBy = "lectureSchedule", cascade = CascadeType.ALL)
    private List<ApplicationHistory> applicationHistoryList;

}
