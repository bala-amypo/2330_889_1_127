// package com.example.demo.service;

// import com.example.demo.entity.PriorityRule;

// import java.util.List;

// public interface PriorityRuleService {

//     int calculatePriority(String category);

//     List<PriorityRule> getAllRules();
// }
package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.PriorityRule;

public interface PriorityRuleService {

    List<PriorityRule> getAllRules();

    List<PriorityRule> getActiveRules();

    int computePriorityScore(com.example.demo.entity.Complaint complaint);
}
