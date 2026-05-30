package com.lcwr.validation_exception_handling.validation_exception_handling.repository;

import com.lcwr.validation_exception_handling.validation_exception_handling.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositroy extends JpaRepository<User,Integer> {
    User findByUserId(int id);
}
