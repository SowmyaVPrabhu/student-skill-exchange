package com.skillshare.student_skill_exchange.repository;

import com.skillshare.student_skill_exchange.entity.Skill;
import com.skillshare.student_skill_exchange.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillRepository extends JpaRepository<Skill,Long> {
    List<Skill> findByUserId(Long userId);

    List<Skill> findBySkillNameContainingIgnoreCase(String skillName);
}
