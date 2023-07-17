// RoleService.java
package com.nithin.demoUsers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nithin.demoUsers.model.Role;
import com.nithin.demoUsers.repository.RoleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Role getRoleById(Long id) {
        Optional<Role> optionalRole = roleRepository.findById(id);
        return optionalRole.orElse(null);
    }

    public Role updateRole(Long id, Role updatedRole) {
        Role existingRole = getRoleById(id);
        if (existingRole != null) {
            existingRole.setName(updatedRole.getName());
            existingRole.setDescription(updatedRole.getDescription());
            // Set other properties as needed

            return roleRepository.save(existingRole);
        } else {
            return null;
        }
    }

    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }

    // Add missing getName() and getDescription() methods
    public String getName(Role role) {
        return role.getName();
    }

    public String getDescription(Role role) {
        return role.getDescription();
    }
}
