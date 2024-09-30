package com.hhplus.hhplus2week.specialClass;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "TB_SPECIAL_CLASS_ENROL")
public class SpecialClassEnrol {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private long id;

    @Column(name = "USER_ID")
    private long userId;

    @Column(name = "class_ID")
    private long classId;

    @Column(name = "ENROL_DATE")
    private Timestamp enrolDate;
}
