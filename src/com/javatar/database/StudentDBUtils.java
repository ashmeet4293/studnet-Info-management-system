package com.javatar.database;

import com.javatar.domain.Student;
import com.javatar.service.StudentDBOperation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class StudentDBUtils implements StudentDBOperation {

    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private Connection connection;

    @Override
    public Boolean insertStudent(Student student) {
        connection = JavaConnector.createConnection();
        if (connection != null) {
            try {
                String query = "INSERT INTO student (name, rollNo, fee, address,school, DOB, email, username, password,gender) VALUES(?,?,?,?,?,?,?,?,?,?)";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, student.getName());
                preparedStatement.setInt(2, student.getRollNo());
                preparedStatement.setDouble(3, student.getFee());
                preparedStatement.setString(4, student.getAddress());
                preparedStatement.setString(5, student.getSchool());
                preparedStatement.setString(6, student.getDOB());
                preparedStatement.setString(7, student.getEmail());
                preparedStatement.setString(8, student.getUsername());
                preparedStatement.setString(9, student.getPassword());
                preparedStatement.setString(10, student.getGender());

                preparedStatement.execute();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(StudentDBUtils.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            System.out.println("cannot cestablish connection");
        }

        return false;
    }

    @Override
    public Boolean updateStudent(Student student) {
        connection = JavaConnector.createConnection();
        if (connection != null) {
            try {
                String query = "UPDATE student SET name =?, rollNo=?, fee=?, address=?, school=?, DOB=?, email=?, username=?, password=?, gender=? WHERE id=? ";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, student.getName());
                preparedStatement.setInt(2, student.getRollNo());
                preparedStatement.setDouble(3, student.getFee());
                preparedStatement.setString(4, student.getAddress());
                preparedStatement.setString(5, student.getSchool());
                preparedStatement.setString(6, student.getDOB());
                preparedStatement.setString(7, student.getEmail());
                preparedStatement.setString(8, student.getUsername());
                preparedStatement.setString(9, student.getPassword());
                preparedStatement.setString(10, student.getGender());

                preparedStatement.setInt(11, student.getId());
                preparedStatement.executeUpdate();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(StudentDBUtils.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            System.out.print("cannot establish connection");
        }

        return false;

    }

    @Override
    public Boolean deleteStudent(Integer id) {
        connection = JavaConnector.createConnection();
        if (connection != null) {
            try {
                String query = "DELETE FROM student WHERE id=? ";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, id);

                preparedStatement.executeUpdate();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(StudentDBUtils.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            System.out.print("cannot establish connection");
        }

        return false;

    }

    @Override
    public ObservableList<Student> readStudent() {
        ObservableList<Student> listOfStudent = FXCollections.observableArrayList();
        Student student = new Student();
        connection = JavaConnector.createConnection();
        if (connection != null) {
            try {
                String query = "SELECT * FROM student";
                preparedStatement = connection.prepareStatement(query);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    student.setId(resultSet.getInt("id"));
                    student.setName(resultSet.getString("name"));
                    student.setRollNo(resultSet.getInt("rollNo"));
                    student.setFee(resultSet.getDouble("fee"));
                    student.setAddress(resultSet.getString("address"));
                    student.setSchool(resultSet.getString("school"));
                    student.setUsername(resultSet.getString("username"));
                    student.setDOB(resultSet.getString("DOB"));
                    student.setEmail(resultSet.getString("email"));
                    student.setPassword(resultSet.getString("password"));
                    student.setGender(resultSet.getString("gender"));

                    listOfStudent.add(student);
                    student = new Student();

                }
                return listOfStudent;
            } catch (SQLException ex) {
                Logger.getLogger(StudentDBUtils.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            System.out.println("cannot cestablish connection");
        }

        return null;
    }

    @Override
    public Boolean login(String username, String password) {
        connection = JavaConnector.createConnection();
        if (connection != null) {
            try {
                String query = "SELECT * FROM student WHERE username=? AND password=?";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return true;
                }

            } catch (SQLException ex) {
                Logger.getLogger(StudentDBUtils.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;

    }

    @Override
    public Boolean checkUsername(String username) {
        connection = JavaConnector.createConnection();
        if (connection != null) {
            try {
                String query = "SELECT * FROM student WHERE username=? ";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, username);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return true;
                }

            } catch (SQLException ex) {
                Logger.getLogger(StudentDBUtils.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

}
