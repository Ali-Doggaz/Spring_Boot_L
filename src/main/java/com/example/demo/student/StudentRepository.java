package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> { // Classe + type primary key

    @Query("SELECT s FROM Student s WHERE s.Email = ?1")
    Optional<Student> findStudentByEmail(String email);

    @Transactional
    @Modifying
    @Query("DELETE FROM Student S Where S.Email = ?1")
    void deleteByEmail(String email);
}
