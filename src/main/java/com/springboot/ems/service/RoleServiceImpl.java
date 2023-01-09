package com.springboot.ems.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.ems.model.Role;
import com.springboot.ems.repo.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role getEmployeeRole() {
        // Employee
        Optional<Role> optional = roleRepository.findById(2);
        Role role = null;
        if (optional.isPresent())
            role = optional.get();
        else
            throw new RuntimeException("ROLE NOT FOUND FOR 1");
        return role;
    }

}
