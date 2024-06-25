package com.spring.projetospring.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.spring.projetospring.student.Student;
import com.spring.projetospring.student.repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository
            .findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
       boolean exists =  studentRepository.existsById(studentId);
       if (!exists) {
            throw new IllegalStateException(
                "Student with id " + studentId + " does not exists.");
       }
       studentRepository.deleteById(studentId);
    }
}

