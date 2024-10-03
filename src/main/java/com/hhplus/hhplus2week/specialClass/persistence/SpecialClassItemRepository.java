package com.hhplus.hhplus2week.specialClass.persistence;

import com.hhplus.hhplus2week.specialClass.domain.entity.SpecialClassItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SpecialClassItemRepository extends JpaRepository<SpecialClassItem, Long> {
    List<SpecialClassItem> findAllByClassId(long classId);

    @Query("SELECT i FROM SpecialClassItem i WHERE i.openDate > :date")
    List<SpecialClassItem> findSpecialItemsAfterTheDate(@Param("date") LocalDateTime date);

    List<SpecialClassItem> findSpecialClassItemByUserId(@Param("userId") Long userId);
}
