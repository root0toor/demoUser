package com.nithin.demoUsers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nithin.demoUsers.model.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
}
