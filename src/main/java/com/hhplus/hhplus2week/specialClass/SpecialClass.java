package com.hhplus.hhplus2week.specialClass;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_CLASS")
public class SpecialClass {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "HEADCOUNT")
    private long headcount;

    @Column(name = "CURRENT_HEADCOUNT")
    private long currentHeadcount;
}
