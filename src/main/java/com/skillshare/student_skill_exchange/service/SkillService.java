package com.skillshare.student_skill_exchange.service;


import com.skillshare.student_skill_exchange.dto.SkillMatchDTO;
import com.skillshare.student_skill_exchange.entity.Skill;
import com.skillshare.student_skill_exchange.entity.User;
import com.skillshare.student_skill_exchange.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SkillService {

    @Autowired
    private SkillRepository skillRepository;


    public List<Skill> getAllSkills(){
        return skillRepository.findAll();
    }

    public List<SkillMatchDTO> findMatches() {

        List<Skill> skills = skillRepository.findAll();

        List<SkillMatchDTO> matches = new ArrayList<>();

        for (Skill teacher : skills) {

            if ("TEACH".equalsIgnoreCase(teacher.getSkillType())) {

                for (Skill learner : skills) {

                    if ("LEARN".equalsIgnoreCase(learner.getSkillType())
                            && teacher.getSkillName()
                            .equalsIgnoreCase(learner.getSkillName())) {

                        matches.add(
                                new SkillMatchDTO(
                                        teacher.getSkillName(),
                                        teacher.getUser().getName(),
                                        learner.getUser().getName()
                                )
                        );
                    }
                }
            }
        }

        return matches;
    }

    public List<Skill> getSkillsByUser(User user) {
        return skillRepository.findByUserId(user.getId());
    }

    public Skill saveSkill(Skill skill){

        System.out.println("Skill User ID = "
                + skill.getUser().getId());

        return skillRepository.save(skill);
    }

    public Skill getSkillById(Long id) {
        return skillRepository.findById(id).orElse(null);
    }

    public void deleteSkill(Long id) {
        skillRepository.deleteById(id);
    }

    public List<Skill> searchSkills(String skillName) {

        return skillRepository
                .findBySkillNameContainingIgnoreCase(skillName);
    }


}
