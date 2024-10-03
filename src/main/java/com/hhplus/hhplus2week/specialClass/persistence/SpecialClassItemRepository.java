package com.hhplus.hhplus2week.specialClass.persistence;

import com.hhplus.hhplus2week.specialClass.domain.entity.SpecialClassItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecialClassItemRepository extends JpaRepository<SpecialClassItem, Long> {
    List<SpecialClassItem> findAllByClassId(long classId);
}
