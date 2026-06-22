package com.skillshare.student_skill_exchange.service;

import com.skillshare.student_skill_exchange.entity.SkillRequest;
import com.skillshare.student_skill_exchange.entity.User;
import com.skillshare.student_skill_exchange.repository.SkillRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillRequestService {

    @Autowired
    private SkillRequestRepository skillRequestRepository;

    public SkillRequest saveRequest(SkillRequest request) {
        return skillRequestRepository.save(request);
    }

    public List<SkillRequest> getRequestsForReceiver(User receiver) {
        return skillRequestRepository.findByReceiver(receiver);
    }

    public SkillRequest getRequestById(Long id) {
        return skillRequestRepository.findById(id).orElse(null);
    }



}