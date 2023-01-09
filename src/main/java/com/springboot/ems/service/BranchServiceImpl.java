package com.springboot.ems.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.ems.model.Branch;
import com.springboot.ems.model.User;
import com.springboot.ems.repo.BranchRepository;

@Service
public class BranchServiceImpl implements BranchService {
	
	@Autowired
	private BranchRepository branchRepository;

	@Override
	public List<Branch> getAllBranches() {
		return branchRepository.findAll();
	}

	@Override
	public void saveBranch(Branch branch) {
		this.branchRepository.save(branch);
	}

	@Override
	public Branch getBranchById(int id) {
		Optional<Branch> optional = branchRepository.findById(id);
		Branch branch = null;
		if(optional.isPresent()) {
			branch = optional.get();
		}else {
			throw new RuntimeException("Branch not found for id :: " + id);
		}
		return branch;
	}

	@Override
	public void deleteBranchById(int id) {
		this.branchRepository.deleteById(id);
		
	}

}
