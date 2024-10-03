package com.hhplus.hhplus2week.specialClass.persistence;

import com.hhplus.hhplus2week.specialClass.domain.entity.SpecialEnrolment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecialEnrolmentRepository extends JpaRepository<SpecialEnrolment, Long> {
    SpecialEnrolment findByUserId(long userId);

    List<SpecialEnrolment> findSpecialEnrolmentsByUserId(long userId);
}
