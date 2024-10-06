package com.hhplus.hhplus2week.specialClass.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * 강의 정보
 */
@Entity
@Table(name = "TB_SPECIAL_CLASS")
@Getter @Setter
public class SpecialClass {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "TEACHER")
    private String teacher;
}
