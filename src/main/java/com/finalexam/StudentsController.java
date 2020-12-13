package com.finalexam;

import com.finalexam.dao.DatabaseConnection;
import com.finalexam.dao.StudentData;
import com.finalexam.dao.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.util.List;

@Controller
public class StudentsController {

    @RequestMapping(value = "/getStudents", method = RequestMethod.GET)
    public String getUsers(Model model) throws Exception {
        List<StudentData> users = getListOfUsers();
        StudentsService userList = new StudentsService();
        userList.setStudents(users);
        model.addAttribute("Students", userList);
        return "displaylist";
    }

    private List<StudentData> getListOfUsers() {
        try {
            StudentService studentService = new StudentService(new DatabaseConnection().connect());
            return studentService.display();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    private String addStudent(ModelMap model, @RequestParam String studentNumber, @RequestParam String studentName, @RequestParam double gpa) {
        try {
            StudentService studentService = new StudentService(new DatabaseConnection().connect());
            studentService.update(new StudentData(studentNumber, studentName, gpa));
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return "redirect:/displaylist";
    }

    @RequestMapping(value = "/editStudent", method = RequestMethod.POST)
    private String editStudent(ModelMap model, @RequestParam String studentNumber, @RequestParam String studentName, @RequestParam double gpa) {
        try {
            StudentService studentService = new StudentService(new DatabaseConnection().connect());
            studentService.edit(new StudentData(studentNumber, studentName, gpa), studentNumber);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return "redirect:/displaylist";
    }


    @RequestMapping(value = "/deleteStudent", method = RequestMethod.GET)
    private String deleteStudent(ModelMap model, @RequestParam String studentNumber) {
        try {
            StudentService studentService = new StudentService(new DatabaseConnection().connect());
            studentService.delete(studentNumber);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return "redirect:/displaylist";
    }

}
