package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Complaint;
import com.example.demo.entity.PriorityRule;
import com.example.demo.repository.PriorityRuleRepository;
import com.example.demo.service.PriorityRuleService;

@Service
public class PriorityRuleServiceImpl implements PriorityRuleService {

    private final PriorityRuleRepository priorityRuleRepository;

    public PriorityRuleServiceImpl(PriorityRuleRepository priorityRuleRepository) {
        this.priorityRuleRepository = priorityRuleRepository;
    }

    @Override
    public List<PriorityRule> getAllRules() {
        List<PriorityRule> rules = priorityRuleRepository.findAll();
        return rules;
    }

    @Override
    public List<PriorityRule> getActiveRules() {
        List<PriorityRule> activeRules = priorityRuleRepository.findByActiveTrue();
        return activeRules;
    }

    @Override
    public int computePriorityScore(Complaint complaint) {

        int score = 0;

        List<PriorityRule> rules = getActiveRules();

        if (rules != null) {
            for (PriorityRule rule : rules) {
                score = score + rule.getWeight();
            }
        }

        return score;
    }
}
