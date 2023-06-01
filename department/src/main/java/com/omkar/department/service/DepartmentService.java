package com.omkar.department.service;

import com.omkar.department.model.Department;
import com.omkar.department.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository repository;

    public Department saveDepartment(Department department) {
        return repository.save(department);
    }

    public Department getDepartment(Long departmentId) {
        return repository.findById(departmentId).orElse(new Department());
    }
}
