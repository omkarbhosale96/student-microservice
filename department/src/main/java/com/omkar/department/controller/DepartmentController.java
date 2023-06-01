package com.omkar.department.controller;

import com.omkar.department.model.Department;
import com.omkar.department.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private static final Logger LOGGER= LoggerFactory.getLogger(DepartmentController.class);
    @Autowired
    DepartmentService service;

    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department){
        LOGGER.info("saveDepartment {}: ",department.getDepartmentId());
        return service.saveDepartment(department);
    }

    @GetMapping("/{id}")
    public Department getDepartment(@PathVariable("id") Long departmentId){
        LOGGER.info("getDepartment {}:",departmentId);
        return service.getDepartment(departmentId);
    }
}
