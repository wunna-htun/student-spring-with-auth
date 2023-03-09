package com.example.studentregistration.service;


import com.example.studentregistration.dto.StudentDTO;
import com.example.studentregistration.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentService {

    Student save(StudentDTO studentDTO);

    Student update(Long id, StudentDTO studentDTO);

    void delete(Long id);

    Student getById(Long id);

    Page<Student> getAll(Pageable pageable);

}

