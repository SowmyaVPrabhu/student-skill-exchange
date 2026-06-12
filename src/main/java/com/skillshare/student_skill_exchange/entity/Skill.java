package com.skillshare.student_skill_exchange.entity;

import jakarta.persistence.*;

@Entity
@Table(name="skills")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String skillName;
    private String skillType;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public Skill(){
    }

    public Skill(Long id, String skillName, String skillType, User user) {
        this.id = id;
        this.skillName = skillName;
        this.skillType = skillType;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getSkillType() {
        return skillType;
    }

    public void setSkillType(String skillType) {
        this.skillType = skillType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
