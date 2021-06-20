package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{email}")
    public void deleteStudent(@PathVariable("email") String email){
        studentService.deleteStudentByEmail(email);
    }

    @PutMapping(path = "{id}")
    public void updateStudent(@PathVariable Long id,
                              @RequestParam(required = false) String new_email,
                              @RequestParam(required = false) String new_name) {
        System.out.println("ici");
        studentService.updateStudent(id, new_email, new_name);
    }

}
