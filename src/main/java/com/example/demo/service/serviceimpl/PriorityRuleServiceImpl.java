// package com.example.demo.service.impl;

// import com.example.demo.entity.PriorityRule;
// import com.example.demo.repository.PriorityRuleRepository;
// import com.example.demo.service.PriorityRuleService;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class PriorityRuleServiceImpl implements PriorityRuleService {

//     private final PriorityRuleRepository priorityRuleRepository;

//     public PriorityRuleServiceImpl(PriorityRuleRepository priorityRuleRepository) {
//         this.priorityRuleRepository = priorityRuleRepository;
//     }

//     @Override
//     public int calculatePriority(String category) {
//         return priorityRuleRepository.findByCategory(category)
//                 .map(PriorityRule::getBaseScore)
//                 .orElse(0);
//     }

//     @Override
//     public List<PriorityRule> getAllRules() {
//         return priorityRuleRepository.findAll();
//     }
// }
package com.example.demo.service.impl;

import com.example.demo.entity.Complaint;
import com.example.demo.entity.PriorityRule;
import com.example.demo.repository.PriorityRuleRepository;
import com.example.demo.service.PriorityRuleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriorityRuleServiceImpl implements PriorityRuleService {

    private final PriorityRuleRepository repo;

    public PriorityRuleServiceImpl(PriorityRuleRepository repo) {
        this.repo = repo;
    }

    @Override
    public int computePriorityScore(Complaint complaint) {
        return 0; // dummy score
    }

    @Override
    public List<PriorityRule> getActiveRules() {
        return repo.findByActiveTrue();
    }
}
