package com.skillshare.student_skill_exchange.repository;

import com.skillshare.student_skill_exchange.entity.RequestStatus;
import com.skillshare.student_skill_exchange.entity.SkillRequest;
import com.skillshare.student_skill_exchange.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillRequestRepository
        extends JpaRepository<SkillRequest, Long> {

    List<SkillRequest> findByReceiver(User receiver);

    long countByStatus(RequestStatus status);

    List<SkillRequest> findBySender(User sender);

}