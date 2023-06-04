package com.omkar.department.controller;

import com.omkar.department.client.StudentClient;
import com.omkar.department.model.Department;
import com.omkar.department.model.Student;
import com.omkar.department.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private static final Logger LOGGER= LoggerFactory.getLogger(DepartmentController.class);
    @Autowired
    DepartmentService service;

    @Autowired
    StudentClient studentClient;

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

    @GetMapping("/all")
    public List<Department> getAllDepartments(){
        return service.getAllDepartments();
    }

    @GetMapping("/withStudents/{id}")
    public Department getDepartmentWithStudents(@PathVariable("id") Long departmentId){
        Department department=service.getDepartment(departmentId);
        List<Student> studentList=studentClient.findByDepartment(department.getDepartmentId());
        department.setStudentList(studentList);
        return department;
    }
}
