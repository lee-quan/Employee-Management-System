package com.springboot.ems.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.ems.model.Branch;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Integer> {

}
