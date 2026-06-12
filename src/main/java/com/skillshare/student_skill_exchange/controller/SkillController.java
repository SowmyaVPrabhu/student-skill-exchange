package com.skillshare.student_skill_exchange.controller;


import com.skillshare.student_skill_exchange.entity.Skill;
import com.skillshare.student_skill_exchange.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SkillController {

    @Autowired
    private SkillService skillService;

    @GetMapping("/add-skill")
    public String showSkillPage(Model model){
        model.addAttribute("skill",new Skill());

        return "add-skill";
    }

    @PostMapping("/save-skill")
    public String saveSkill(@ModelAttribute Skill skill){

        skillService.saveSkill(skill);
        return "redirect:/add-skill";
    }

    @GetMapping("/skills")
    public String viewSkills(Model model){

        model.addAttribute("skills",skillService.getAllSkills());

        return "skills";
    }

    @GetMapping("/skills-with-users")
    public String viewSkillsWithUsers(Model model) {

        model.addAttribute("skills",
                skillService.getAllSkills());

        return "skills-with-users";
    }
}
