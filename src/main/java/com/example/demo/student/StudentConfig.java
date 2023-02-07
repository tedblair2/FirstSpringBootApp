package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student ted=new Student(
                    "Ted",
                    LocalDate.of(1998,11,26),
                    "ominoblair@gmail.com");
            Student israel=new Student(
                    "Israel",
                    LocalDate.of(2002,10,10),
                    "israel@gmail.com"
            );
            Student valarie=new Student(
                    "Valarie",
                    LocalDate.of(1988,10,10),
                    "israel@gmail.com"
            );
            Student young=new Student(
                    "Young",
                    LocalDate.of(1993,8,10),
                    "israel@gmail.com"
            );
            repository.saveAll(
                    List.of(
                            ted,israel,valarie,young
                    )
            );
        };
    }
}
