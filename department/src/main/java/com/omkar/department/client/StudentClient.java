package com.omkar.department.client;

import com.omkar.department.model.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange
public interface StudentClient {


    @GetExchange("/student/department/{departmentId}")
    List<Student> findByDepartment(@PathVariable("departmentId") Long departmentId);
}
