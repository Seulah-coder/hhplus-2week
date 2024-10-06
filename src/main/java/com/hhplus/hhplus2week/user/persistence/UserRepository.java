package com.hhplus.hhplus2week.user.persistence;

import com.hhplus.hhplus2week.user.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
