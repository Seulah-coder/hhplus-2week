package com.hhplus.hhplus2week.specialClass.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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

    @Column(name = "USER_ID")
    private long userId;

    @Column(name ="ENROL_TIME")
    private long enrolTime;
}
