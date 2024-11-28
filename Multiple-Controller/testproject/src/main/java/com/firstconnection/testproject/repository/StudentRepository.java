package com.firstconnection.testproject.repository;

import com.firstconnection.testproject.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {}
