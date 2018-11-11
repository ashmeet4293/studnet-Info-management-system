package com.javatar.service;


import com.javatar.domain.Student;
import java.util.List;
import javafx.collections.ObservableList;

public interface StudentDBOperation {
    Boolean insertStudent( Student student);
    Boolean updateStudent (Student student);
    Boolean deleteStudent (Integer id);
    
    ObservableList <Student> readStudent();
    
    Boolean login(String username, String password);
    
    Boolean checkUsername(String username);
}
