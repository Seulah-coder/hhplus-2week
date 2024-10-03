package com.hhplus.hhplus2week.specialClass.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name = "TB_SPECIAL_ENROLMENT")
@Getter
@Setter
public class SpecialEnrolment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private long id;

    @Column(name = "CLASS_ITEM_ID")
    private long classItemId;

    @Column(name = "USED_ID")
    private long usedId;

    @Column(name ="ENROL_TIME")
    private long enrolTime;
}
