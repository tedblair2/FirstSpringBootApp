package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "student")
public class StudentController {

    public final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping()
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping()
    public void registerStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }
    @DeleteMapping(path = "{id}")
    public void deleteStudent(@PathVariable("id") Long id){
        studentService.deleteStudent(id);
    }
    @PutMapping(path = "{id}")
    public void updateStudent(
            @PathVariable("id") Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email
    ){
        studentService.updateStudent(id,name,email);
    }
}
