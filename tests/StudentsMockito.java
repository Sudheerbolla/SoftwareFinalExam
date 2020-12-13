import com.finalexam.StudentsService;
import com.finalexam.dao.StudentData;
import com.finalexam.dao.StudentService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class StudentsMockito {

    @Test
    void retrieveStudentsToString() {
        StudentsService todoService = mock(StudentsService.class);
        List<StudentData> studentDataArrayList = new ArrayList<>();
        studentDataArrayList.add(new StudentData("10001","Student name",3.8));
        when(todoService.getStudents()).thenReturn(studentDataArrayList);
        assertEquals(1, studentDataArrayList.size());
    }

}
