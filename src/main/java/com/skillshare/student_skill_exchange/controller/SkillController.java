package com.skillshare.student_skill_exchange.controller;


import com.skillshare.student_skill_exchange.entity.RequestStatus;
import com.skillshare.student_skill_exchange.entity.Skill;
import com.skillshare.student_skill_exchange.entity.SkillRequest;
import com.skillshare.student_skill_exchange.entity.User;
import com.skillshare.student_skill_exchange.service.SkillRequestService;
import com.skillshare.student_skill_exchange.service.SkillService;
import com.skillshare.student_skill_exchange.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SkillController {

    @Autowired
    private SkillService skillService;

    @Autowired
    private UserService userService;

    @Autowired
    private SkillRequestService skillRequestService;

    @GetMapping("/add-skill")
    public String showSkillPage(Model model){
        model.addAttribute("skill",new Skill());

        return "add-skill";
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

    @GetMapping("/matches")
    public String viewMatches(Model model){
        model.addAttribute("matches",skillService.findMatches());
        return "matches";
    }

    @GetMapping("/my-skills")
    public String mySkills(Model model) {

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        String email = authentication.getName();
        System.out.println("Current email = " + email);

        User user = userService.findByEmail(email);
        System.out.println("User ID = " + user.getId());

        List<Skill> skills = skillService.getSkillsByUser(user);

        System.out.println("Skills found = " + skills.size());

        model.addAttribute("skills", skills);

        return "my-skills";
    }

    @PostMapping("/save-skill")
    public String addSkill(@ModelAttribute Skill skill) {

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        String email = authentication.getName();

        User user = userService.findByEmail(email);

        skill.setUser(user);

        System.out.println("Saving skill for user ID = " + user.getId());

        skillService.saveSkill(skill);

        return "redirect:/my-skills";
    }

    @GetMapping("/edit-skill/{id}")
    public String showEditSkillPage(@PathVariable Long id,
                                    Model model) {

        Skill skill = skillService.getSkillById(id);

        model.addAttribute("skill", skill);

        return "edit-skill";
    }

    @PostMapping("/update-skill")
    public String updateSkill(@ModelAttribute Skill skill) {

        Skill existingSkill = skillService.getSkillById(skill.getId());

        // Preserve the owner of the skill
        skill.setUser(existingSkill.getUser());

        skillService.saveSkill(skill);

        return "redirect:/my-skills";
    }

    @GetMapping("/delete-skill/{id}")
    public String deleteSkill(@PathVariable Long id) {

        skillService.deleteSkill(id);

        return "redirect:/my-skills";
    }

    @GetMapping("/search-skills")
    public String searchSkills(
            @RequestParam(required = false) String keyword,
            Model model) {

        if (keyword != null) {
            model.addAttribute(
                    "skills",
                    skillService.searchSkills(keyword)
            );
        }

        return "search-skills";
    }

    @GetMapping("/send-request/{id}")
    public String sendRequest(@PathVariable Long id) {

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        String email = authentication.getName();

        User sender = userService.findByEmail(email);

        Skill skill = skillService.getSkillById(id);

        User receiver = skill.getUser();

        SkillRequest request = new SkillRequest();

        request.setSender(sender);
        request.setReceiver(receiver);
        request.setSkill(skill);
        request.setStatus(RequestStatus.PENDING);

        skillRequestService.saveRequest(request);

        return "redirect:/search-skills";
    }

    @GetMapping("/requests")
    public String viewRequests(Model model) {

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        String email = authentication.getName();

        User receiver = userService.findByEmail(email);

        model.addAttribute(
                "requests",
                skillRequestService.getRequestsForReceiver(receiver));

        return "requests";
    }

    @GetMapping("/accept-request/{id}")
    public String acceptRequest(@PathVariable Long id) {

        SkillRequest request =
                skillRequestService.getRequestById(id);

        request.setStatus(RequestStatus.ACCEPTED);

        skillRequestService.saveRequest(request);

        return "redirect:/requests";
    }

    @GetMapping("/reject-request/{id}")
    public String rejectRequest(@PathVariable Long id) {

        SkillRequest request =
                skillRequestService.getRequestById(id);

        request.setStatus(RequestStatus.REJECTED);

        skillRequestService.saveRequest(request);

        return "redirect:/requests";
    }


}
