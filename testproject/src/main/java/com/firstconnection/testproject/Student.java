package com.firstconnection.testproject;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "student")  
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    private int id;

    @Column(name = "Student_FirstName")  
    private String first_name;

    @Column(name = "Student_LastName")  
    private String last_name;

    @Column(name = "Student_Grade")  
    private String grade;

    @Column(name = "Student_Department")  
    private String department;

    // Constructor
    public Student(String first_name, String last_name, String grade, String department) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.grade = grade;
        this.department = department;
    }

    // Default constructor
    public Student() {
    }

    // Getter and Setter methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
