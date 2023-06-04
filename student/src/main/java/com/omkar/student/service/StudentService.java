package com.omkar.student.service;

import com.omkar.student.model.Student;
import com.omkar.student.repository.StudentRepository;
import com.omkar.student.vo.Department;
import com.omkar.student.vo.StudentDepartmentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository repository;

    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    public StudentDepartmentVO getStudent(Long studentId) {
        RestTemplate template=new RestTemplate();
        Student student=repository.findById(studentId).orElse(new Student());
        StudentDepartmentVO studentDepartmentVO=new StudentDepartmentVO();
        Department department=template.getForEntity("http://localhost:8080/department/"+student.getDepartmentId(), Department.class).
                getBody();
        studentDepartmentVO.setStudent(student);
        studentDepartmentVO.setDepartment(department);
        return studentDepartmentVO;
    }

    public List<Student> findByDepartment(Long departmentId) {
        return repository.findByDepartmentId(departmentId);
    }
}
