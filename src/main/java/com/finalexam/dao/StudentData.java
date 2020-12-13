package com.finalexam.dao;

public class StudentData {
    private String studentNumber, studentName;
    private double gpa;

    public StudentData() {

    }

    public StudentData(String studentNumber, String studentName, double gpa) {
        this.studentName = studentName;
        this.studentNumber = studentNumber;
        this.gpa = gpa;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }


}
