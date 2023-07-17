// PermissionService.java
package com.nithin.demoUsers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nithin.demoUsers.model.Permission;
import com.nithin.demoUsers.repository.PermissionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PermissionService {
    private final PermissionRepository permissionRepository;

    @Autowired
    public PermissionService(PermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }

    public Permission createPermission(Permission permission) {
        return permissionRepository.save(permission);
    }

    public List<Permission> getAllPermissions() {
        return permissionRepository.findAll();
    }

    public Permission getPermissionById(Long id) {
        Optional<Permission> optionalPermission = permissionRepository.findById(id);
        return optionalPermission.orElse(null);
    }

    public Permission updatePermission(Long id, Permission updatedPermission) {
        Permission existingPermission = getPermissionById(id);
        if (existingPermission != null) {
            existingPermission.setName(updatedPermission.getName());
            existingPermission.setDescription(updatedPermission.getDescription());
            // Set other properties as needed

            return permissionRepository.save(existingPermission);
        } else {
            return null;
        }
    }

    public void deletePermission(Long id) {
        permissionRepository.deleteById(id);
    }

    // Add missing getName() and getDescription() methods
    public String getName(Permission permission) {
        return permission.getName();
    }

    public String getDescription(Permission permission) {
        return permission.getDescription();
    }
}
