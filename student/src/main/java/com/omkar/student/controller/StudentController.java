package com.omkar.student.controller;

import com.omkar.student.model.Student;
import com.omkar.student.service.StudentService;
import com.omkar.student.vo.StudentDepartmentVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    private static final Logger LOGGER= LoggerFactory.getLogger(StudentController.class);
    @Autowired
    StudentService service;

    @PostMapping("/")
    public Student saveStudent(@RequestBody Student student){
        LOGGER.info("saveStudent :{}",student.getStudentId());
        return service.saveStudent(student);
    }

    @GetMapping("/{id}")
    public StudentDepartmentVO getStudent(@PathVariable("id") Long studentId){
        LOGGER.info("getStudent :{}",studentId);
        return service.getStudent(studentId);
    }
}
