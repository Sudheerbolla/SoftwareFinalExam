/*
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ToBusinessImplTest_Mockito {

    @Test
    void retrieveToDosRelatedToString() {
        TodoService todoService = mock(TodoService.class);
        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn dance");
        when(todoService.retriveTodos("Hello 2")).thenReturn(todos);

        ToBusinessImpl toBusiness = new ToBusinessImpl(todoService);
        List<String> filt = toBusiness.retrieveToDosRelatedToString("Spring");

        assertEquals(2, filt.size());
    }

}*/
