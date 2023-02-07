package com.example.demo.student;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    Long id;
    String name;
    @Transient
    int age;
    LocalDate DoB;
    String email;

    public Student(){
    }

    public Student(Long id, String name,LocalDate doB, String email){
        this.id = id;
        this.name = name;
        DoB = doB;
        this.email = email;
    }

    public Student(String name,LocalDate doB, String email){
        this.name = name;
        DoB = doB;
        this.email = email;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getAge(){
        return Period.between(this.DoB,LocalDate.now()).getYears();
    }

    public void setAge(int age){
        this.age = age;
    }

    public LocalDate getDoB(){
        return DoB;
    }

    public void setDoB(LocalDate doB){
        DoB = doB;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    @Override
    public String toString(){
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", DoB=" + DoB +
                ", email='" + email + '\'' +
                '}';
    }
}
