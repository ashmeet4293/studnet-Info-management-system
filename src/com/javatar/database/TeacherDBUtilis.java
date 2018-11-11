package com.javatar.database;


import com.javatar.domain.Teacher;
import com.javatar.service.TeacherDBOperation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TeacherDBUtilis implements TeacherDBOperation {

    private PreparedStatement preparedStatement;
    private Connection connection;

    @Override
    public Boolean insertTeacher(Teacher teacher) {
        connection = JavaConnector.createConnection();
        if (connection != null) {

            try {
                String query = "INSERT INTO teacher (name,department,salary,school,address) VALUES(?,?,?,?,?)";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, teacher.getName());
                preparedStatement.setString(2, teacher.getDepartment());
                preparedStatement.setDouble(3, teacher.getSalary());
                preparedStatement.setString(4, teacher.getSchool());
                preparedStatement.setString(5, teacher.getAddress());
                preparedStatement.execute();
                return true;

            } catch (SQLException ex) {
                ex.printStackTrace();
                Logger.getLogger(TeacherDBUtilis.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            System.out.println("cannot establish connection");
        }
        return false;
    }

    @Override
    public Boolean updateTeacher(Teacher teacher) {
        connection = JavaConnector.createConnection();
        if (connection != null) {

            try {
                String query = "UPDATE teacher SET name=?,department=?,salary=?,school=?,address=? WHERE id=?";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, teacher.getName());
                preparedStatement.setString(2, teacher.getDepartment());
                preparedStatement.setDouble(3, teacher.getSalary());
                preparedStatement.setString(4, teacher.getSchool());
                preparedStatement.setString(5, teacher.getAddress());
                preparedStatement.setInt(6, teacher.getId());
                preparedStatement.executeUpdate();
                return true;

            } catch (SQLException ex) {
                ex.printStackTrace();
                Logger.getLogger(TeacherDBUtilis.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            System.out.println("cannot establish connection");
        }
        return false;
    }



@Override
        public Boolean deleteTeacher(Integer id) {     
            connection = JavaConnector.createConnection();
        if (connection != null) {

            try {
                String query = "DELETE FROM teacher WHERE id=?";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, id);
                
                preparedStatement.executeUpdate();
                return true;

            } catch (SQLException ex) {
                ex.printStackTrace();
                Logger.getLogger(TeacherDBUtilis.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            System.out.println("cannot establish connection");
        }
        return false;
    }     

    

    @Override
        public List<Teacher> readTeacher() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
