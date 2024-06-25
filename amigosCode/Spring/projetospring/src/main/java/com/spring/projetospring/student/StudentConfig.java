package com.spring.projetospring.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.projetospring.student.repository.StudentRepository;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner CommandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student mariam = new Student(
                1L,
                "Mariam",
                "mariam.jamal@gmail.com",
                LocalDate.of(2000, Month.JANUARY, 5)
            );

            Student john = new Student(
                "John",
                "john.alabama@gmail.com",
                LocalDate.of(1987, Month.AUGUST, 5)
            );

            studentRepository.saveAll(List.of(mariam, john));
        };
    }
}
