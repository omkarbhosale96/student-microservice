package com.omkar.student.vo;

import com.omkar.student.model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class StudentDepartmentVO {

    private Student student;
    private Department department;
}
