package com.finalexam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentService implements StudentInterface {

    private Connection databaseConnection;

    public Connection getDatabaseConnection() {
        return databaseConnection;
    }

    public void setDatabaseConnection(Connection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    public StudentService(Connection databaseConnection) throws SQLException {
        this.databaseConnection = databaseConnection;
    }

    public StudentData getStudentObject(String number) throws SQLException, ClassNotFoundException {
        String getObjectQuery = "Select * from studentrecord where snumber = ?";
        PreparedStatement query = databaseConnection.prepareStatement(getObjectQuery);
        query.setString(1, number);

        ResultSet rs = query.executeQuery();
        if (!rs.first()) {
            System.out.println("Record not existing");
            return null;
        }
        return new StudentData(rs.getString("snumber"), rs.getString("sname"), rs.getDouble("gpa"));
    }


    @Override
    public StudentData edit(StudentData studentData, String number) throws SQLException, ClassNotFoundException {
        PreparedStatement query;
        query = databaseConnection.prepareStatement("Update studentrecord set snumber=?, sname=?, gpa=? where snumber = ?");
        query.setString(1, studentData.getStudentNumber());
        query.setString(2, studentData.getStudentName());
        query.setDouble(3, studentData.getGpa());
        query.setString(4, studentData.getStudentNumber());
        query.executeUpdate();
        System.out.println("One record edited");
        return studentData;
    }

    @Override
    public void update(StudentData studentData) throws SQLException, ClassNotFoundException {
        String insertQuery = "INSERT INTO studentrecord VALUES ( ?, ?,? )";
        PreparedStatement query = databaseConnection.prepareStatement(insertQuery);

        query.setString(1, studentData.getStudentNumber());
        query.setString(2, studentData.getStudentName());
        query.setDouble(3, studentData.getGpa());

        query.executeUpdate();

        System.out.println("One record added");
    }

    @Override
    public void delete(String number) throws SQLException {
        String quer1 = "Delete from studentrecord where snumber = ?";
        PreparedStatement query = databaseConnection.prepareStatement(quer1);
        query.setString(1, number);
        query.executeUpdate();
        System.out.println("One record Deleted");
    }

    @Override
    public ArrayList<StudentData> display() throws ClassNotFoundException, SQLException {
        String quer1 = "Select * from studentrecord";
        PreparedStatement query = databaseConnection.prepareStatement(quer1);
        ResultSet rs = query.executeQuery();
        ArrayList<StudentData> studentDataArrayList = new ArrayList<>();
        while (rs.next()) {
            studentDataArrayList.add(new StudentData(rs.getString("snumber"), rs.getString("sname"), rs.getDouble("gpa")));
        }
        return studentDataArrayList;
    }
}
