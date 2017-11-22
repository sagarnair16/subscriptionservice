package com.subscriptionservice.backend.persistence.repositories;

import com.subscriptionservice.backend.persistence.domain.backend.Plan;
import org.springframework.data.repository.CrudRepository;

public interface PlanRepositories extends CrudRepository<Plan,Integer> {
}
