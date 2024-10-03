package com.hhplus.hhplus2week.specialClass.persistence;

import com.hhplus.hhplus2week.specialClass.domain.entity.SpecialClassInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecialClassInventoryRepository extends JpaRepository<SpecialClassInventory, Long> {
    List<SpecialClassInventory> findAllByClassId(long classId);

    List<SpecialClassInventory> findAllBySpecialClassItemId(long itemId);
}
