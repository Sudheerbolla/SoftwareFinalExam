package com.finalexam;

import com.finalexam.dao.StudentData;

import java.util.ArrayList;
import java.util.List;

public class StudentsService {
    private List<StudentData> studentDataList = new ArrayList<>();

    public List<StudentData> getStudents() {
        return studentDataList;
    }

    public void setStudents(List<StudentData> users) {
        this.studentDataList = users;
    }

    public void addStudent(StudentData studentData) {
        studentDataList.add(studentData);
    }

    public void editStudent(StudentData studentData) {
        for (int i = 0, studentDataListSize = studentDataList.size(); i < studentDataListSize; i++) {
            StudentData studentData1 = studentDataList.get(i);
            if (studentData.getStudentNumber().equalsIgnoreCase(studentData1.getStudentNumber())) {
                studentDataList.set(i, studentData);
                return;
            }
        }
    }

    public void deleteStudent(StudentData studentData) {
        int pos = 0;
        for (int i = 0, studentDataListSize = studentDataList.size(); i < studentDataListSize; i++) {
            StudentData studentData1 = studentDataList.get(i);
            if (studentData.getStudentNumber().equalsIgnoreCase(studentData1.getStudentNumber())) {
                pos = i;
                break;
            }
        }
        studentDataList.remove(pos);
    }

}