package com.javatar.service;


import com.javatar.domain.Teacher;
import java.util.List;

public interface TeacherDBOperation {

    Boolean insertTeacher(Teacher teacher);

    Boolean updateTeacher(Teacher teacher);

    Boolean deleteTeacher(Integer id);

    List<Teacher> readTeacher();

}
