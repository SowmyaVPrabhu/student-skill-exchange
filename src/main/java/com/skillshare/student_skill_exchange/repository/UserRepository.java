package com.skillshare.student_skill_exchange.repository;

import com.skillshare.student_skill_exchange.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByEmail(String email);
}
