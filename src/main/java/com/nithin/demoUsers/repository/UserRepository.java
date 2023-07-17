package com.nithin.demoUsers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nithin.demoUsers.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
