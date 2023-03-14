package com.example.studentregistration.service.impl;



import com.example.studentregistration.dto.StudentDTO;
import com.example.studentregistration.exception.StudentNotFoundException;
import com.example.studentregistration.model.Student;
import com.example.studentregistration.repository.StudentRepository;
import com.example.studentregistration.service.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;



    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

//    @Override
//    public Student save(StudentDTO studentDTO) {
//        Student student = new Student();
//        student.setUsername(studentDTO.getUsername());
//        student.setEmail(studentDTO.getEmail());
//        student.setPhone(studentDTO.getPhone());
//        return studentRepository.save(student);
//    }

    @Override
    public Student save(Student studentDTO) {
        Student student = new Student();
        student.setUsername(studentDTO.getUsername());
        student.setEmail(studentDTO.getEmail());
        student.setPhone(studentDTO.getPhone());
        student.setPassword(studentDTO.getPassword());
        return studentRepository.save(student);

    }

    @Override
    public Student update(Long id, StudentDTO studentDTO) {
        Student student = getById(id);
        student.setUsername(studentDTO.getUsername());
        student.setEmail(studentDTO.getEmail());
        student.setPhone(studentDTO.getPhone());
        return studentRepository.save(student);
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student getById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student +"+ id));
    }

    @Override
    public Page<Student> getAll(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

}
