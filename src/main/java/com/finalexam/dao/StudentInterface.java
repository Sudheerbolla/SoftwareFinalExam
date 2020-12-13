package com.finalexam.dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StudentInterface {
    //display, update, delete and edit record
//    public void addStudent(StudentData studentData) throws ClassNotFoundException, SQLException;

    public StudentData edit(StudentData studentData, String number) throws SQLException, ClassNotFoundException;

    public void update(StudentData studentData) throws SQLException, ClassNotFoundException;

    public void delete(String number) throws SQLException;

    public ArrayList<StudentData> display() throws ClassNotFoundException, SQLException;

}
