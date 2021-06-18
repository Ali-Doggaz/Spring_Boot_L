package com.example.demo.student;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.Period;
import javax.persistence.*;

@Entity //For Hibernate
@Table //For the table in our DB

public class Student {
    @Id

    @SequenceGenerator(
            name="student_sequence",
            sequenceName="student_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )

    private Long Id;
    private String Name;
    private LocalDate DOB;
    private String Email;
    @Transient
    private Integer Age;

    public Student() {
    }

    public Student(Long id, String name, LocalDate DOB, String email) {
        Id = id;
        Name = name;
        this.DOB = DOB;
        Email = email;
    }

    public Student(String name, LocalDate DOB, String email) {
        Name = name;
        this.DOB = DOB;
        Email = email;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    //calculate the age using the DOB
    public Integer getAge() {
        return Period.between(DOB, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        Age = age;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", Age=" + Age +
                ", DOB=" + DOB +
                ", Email='" + Email + '\'' +
                '}';
    }
}
