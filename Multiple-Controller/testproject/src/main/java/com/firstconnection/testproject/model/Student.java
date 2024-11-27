package com.firstconnection.testproject.model;


import jakarta.persistence.Entity;

@Entity

public class Student extends Person {

    private String course;
    private int year;

    // Default constructor
    public Student() {}

    // Parameterized constructor
    public Student(String name, int age, String course, int year) {
        super(name, age); 
        this.course = course;
        this.year = year;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
