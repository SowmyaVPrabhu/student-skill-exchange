package com.skillshare.student_skill_exchange.dto;

public class SkillMatchDTO {

    private String skillName;
    private String teacherName;
    private String learnerName;

    public SkillMatchDTO(String skillName,
                         String teacherName,
                         String learnerName) {
        this.skillName = skillName;
        this.teacherName = teacherName;
        this.learnerName = learnerName;
    }

    public String getSkillName() {
        return skillName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public String getLearnerName() {
        return learnerName;
    }
}