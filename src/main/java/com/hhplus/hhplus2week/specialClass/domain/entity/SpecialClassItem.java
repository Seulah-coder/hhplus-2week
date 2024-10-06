package com.hhplus.hhplus2week.specialClass.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 강의 정보에 해당하는 특강 리스트
 */
@Entity
@Table(name = "TB_SPECIAL_CLASS_ITEM")
@Getter
@Setter
public class SpecialClassItem {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private long id;

    @Column(name = "CLASS_ID")
    private long classId;

    @Column(name ="TOTAL_HEADCOUNT")
    private long totalHeadcount;

    @Column(name = "OPEN_DATE")
    private LocalDateTime openDate;
}
