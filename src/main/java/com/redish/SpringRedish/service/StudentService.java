package com.redish.SpringRedish.service;

import com.redish.SpringRedish.model.Student;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {


    Student createStudent(Student student);

    Student findStudentById(Long id);

    Student updateStudent(Long id,Student student);

    void deleteStudent(Long id);
}
