package com.example.demo.student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service // We can use @Component instead, but @Service shows that this is a service layer. ONLY FOR READABILITY.
public class StudentService {
    public List<Student> getStudents(){
        return List.of(new Student(1L,"Ali",20, LocalDate.of(2000, Month.JANUARY, 5),"ali@gmail.com"));
    }
}


