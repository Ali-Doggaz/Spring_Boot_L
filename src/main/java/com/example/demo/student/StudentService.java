package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service // We can use @Component instead, but @Service shows that this is a service layer. ONLY FOR READABILITY.
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()){
            throw new IllegalStateException("Email Taken");
        }

        studentRepository.save(student);
    }

    public void deleteStudentByEmail(String email){
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
        if (!studentOptional.isPresent()){
            throw new IllegalStateException("Student Doesn't Exists");
        }
        studentRepository.deleteByEmail(email);
    }
}


