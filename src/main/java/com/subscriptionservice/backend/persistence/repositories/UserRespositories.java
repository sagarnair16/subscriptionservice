package com.subscriptionservice.backend.persistence.repositories;

import com.subscriptionservice.backend.persistence.domain.backend.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRespositories extends CrudRepository<User,Integer> {
}
