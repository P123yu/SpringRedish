package com.redish.SpringRedish.service.impl;

import com.redish.SpringRedish.model.Student;
import com.redish.SpringRedish.repository.StudentRepository;
import com.redish.SpringRedish.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "students")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    @CachePut(key = "#result.getId()")
    public Student createStudent(Student student) {
        Student savedStudent = studentRepository.save(student);
        System.out.println("Student saved to DB and attempting to cache: " + savedStudent.getId()); // ADD THIS LINE
        return savedStudent;
    }

    @Override
    @Cacheable(key = "#id")
    public Student findStudentById(Long id) {
        System.out.println("Fetching student from DB for ID: " + id);
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    @CachePut(key = "#id")
    public Student updateStudent(Long id, Student student) {
        student.setId(id);
        return studentRepository.save(student);
    }

    @Override
    @CacheEvict(key = "#id")
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}