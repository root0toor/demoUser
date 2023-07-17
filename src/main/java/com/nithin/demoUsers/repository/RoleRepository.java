package com.nithin.demoUsers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nithin.demoUsers.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
