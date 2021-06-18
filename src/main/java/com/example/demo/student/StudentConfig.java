package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student Ali = new Student("Ali", LocalDate.of(2000, Month.JANUARY, 5),"ali@gmail.com");
            Student Alex = new Student("Alex", LocalDate.of(1992, Month.JANUARY, 9),"Alex@gmail.com");

            //save the students to the DB
            repository.saveAll(List.of(Ali, Alex));
        };
    }
}
