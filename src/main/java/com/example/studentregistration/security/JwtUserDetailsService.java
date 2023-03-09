package com.example.studentregistration.security;

import com.example.studentregistration.model.Student;
import com.example.studentregistration.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    private final StudentRepository studentRepository;
    private final PasswordEncoder bcryptEncoder;

//    @Autowired
    public JwtUserDetailsService(StudentRepository studentRepository, PasswordEncoder bcryptEncoder) {
        this.studentRepository = studentRepository;
        this.bcryptEncoder = bcryptEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student student = studentRepository.findByUsername(username);
        if (student == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(student.getUsername(), student.getPassword(),
                new ArrayList<>());
    }

    public Student save(Student student) {
        student.setPassword(bcryptEncoder.encode(student.getPassword()));
        return studentRepository.save(student);
    }
}
