package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    public final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addStudent(Student student){
        Optional<Student> studentemail=studentRepository.findStudentByEmail(student.getEmail());
        if (studentemail.isPresent()){
            throw new IllegalStateException("email taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long id){
        boolean exists=studentRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException("Student does not exist");
        }
        studentRepository.deleteById(id);
    }
    @Transactional
    public void updateStudent(Long id, String name, String email){
        Student student=studentRepository.findById(id).orElseThrow(()->
                new IllegalStateException("Student does not exist"));
        if (name != null && name.length()>0 && !student.getName().equals(name)){
            student.setName(name);
        }
        if (email != null && email.length()>0 && !student.getEmail().equals(email)){
            Optional<Student> studentOptional=studentRepository.findStudentByEmail(email);
            if (studentOptional.isPresent()){
                throw new IllegalStateException("Email is taken");
            }
            student.setEmail(email);
        }
    }
}
