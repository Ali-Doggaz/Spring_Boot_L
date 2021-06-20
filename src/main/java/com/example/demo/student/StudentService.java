package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    @Transactional //permet de modifier la bd avec les getters et setters
    public void updateStudent(Long id, String new_email, String new_name) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if(!studentOptional.isPresent()){
            throw new IllegalStateException("Student Doesn't Exist");
        }
        Student s = studentOptional.get();
        if (new_email != null && new_email.length()>0 && new_email!=s.getEmail()) s.setEmail(new_email);
        if (new_name != null && new_name.length()>0 && new_name!=s.getName()) s.setName(new_name);
        System.out.println(s);
    }
}


