package com.hhplus.hhplus2week.user.persistence;

import com.fasterxml.jackson.databind.introspect.AnnotationCollector;
import com.hhplus.hhplus2week.user.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByMobile(String email);
}
