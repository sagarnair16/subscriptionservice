package com.subscriptionservice.backend.persistence.repositories;

import com.subscriptionservice.backend.persistence.domain.backend.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepositories extends CrudRepository<Role,Integer> {
}
