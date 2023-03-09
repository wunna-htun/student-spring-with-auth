package com.example.studentregistration.repository;


import com.example.studentregistration.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByUsername(String username);

    @Query("SELECT s FROM Student s WHERE s.name LIKE %?1% OR s.email LIKE %?1% OR s.username LIKE %?1%")
    List<Student> search(String keyword);
}
