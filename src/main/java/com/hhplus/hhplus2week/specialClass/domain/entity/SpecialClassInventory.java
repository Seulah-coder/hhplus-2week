package com.hhplus.hhplus2week.specialClass.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 강의 신청 관련
 */
@Entity
@Table(name = "TB_SPECIAL_CLASS_INVENTORY")
@Getter
@Setter
public class SpecialClassInventory {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private long id;

    @Column(name = "CLASS_ID")
    private long classId;

    @Column(name ="ITEM_ID")
    private long specialClassItemId;

    @Column(name ="CURRENT_HEADCOUNT")
    private long currentHeadcount;
}
