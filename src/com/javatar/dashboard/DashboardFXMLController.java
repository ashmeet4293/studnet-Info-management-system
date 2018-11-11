package com.javatar.dashboard;

import com.javatar.domain.Student;
import com.javatar.common.Common;
import com.javatar.database.StudentDBUtils;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import jdk.nashorn.internal.parser.TokenType;

public class DashboardFXMLController implements Initializable {

    @FXML
    private Button btnLogout;

    @FXML
    private TextField txtUserId;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtRollNo;
    @FXML
    private TextField txtFee;
    @FXML
    private TextField txtAddress;
    @FXML
    private TextField txtSchool;
    @FXML
    private DatePicker txtDOB;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField pwdPassword;
    @FXML
    private TableView<Student> tblStudentData;
    @FXML
    private TableColumn<Student, Integer> colId;
    @FXML
    private TableColumn<Student, String> colName;
    @FXML
    private TableColumn<Student, String> colRoll;
    @FXML
    private TableColumn<Student, Double> colFee;
    @FXML
    private TableColumn<Student, String> colDob;
    @FXML
    private TableColumn<Student, String> colUsername;
    @FXML
    private TextField txtSearchUser;
    @FXML
    private RadioButton rdMale;
    @FXML
    private RadioButton rdFemale;

    Student student = new Student();
    StudentDBUtils studentDBUtils = new StudentDBUtils();
    Common common = new Common();
    ObservableList<Student> data;
    FilteredList<Student> filteredData;
    ToggleGroup radioToggleGroup;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        radioToggleGroup = new ToggleGroup();
        rdMale.setToggleGroup(radioToggleGroup);
        rdFemale.setToggleGroup(radioToggleGroup);

        showAllData();
    }

    @FXML
    private void handleActionLogout(ActionEvent event) {
        Stage current = (Stage) btnLogout.getScene().getWindow();
        current.hide();
        common.nextWindow("/com/javatar/main/FXMLDocument.fxml", "login", true);
    }

    @FXML
    private void handleActionBtnClear(ActionEvent event) {
        clearFields();
    }

    @FXML
    private void handleActionBtnCreate(ActionEvent event) {
        RadioButton rbGender = (RadioButton) radioToggleGroup.getSelectedToggle();

        if (studentDBUtils.checkUsername(txtUsername.getText()) || txtUsername.getText().isEmpty()) {
            common.alertMessage("ERROR", "Error", "Username already Reserved Or Empty", " This username : " + txtUsername.getText() + " is not available");

        } else if (txtRollNo.getText().isEmpty() || txtRollNo.getText() == null) {
            common.alertMessage("ERROR", "Error", "Roll Number is emplty", " Please Enter Valid Roll Number");

        } else {

            student = new Student();
            student.setName(txtName.getText());
            student.setRollNo(Integer.parseInt(txtRollNo.getText()));
            student.setFee(Double.parseDouble(txtFee.getText()));
            student.setAddress(txtAddress.getText());
            student.setSchool(txtSchool.getText());
            student.setDOB(txtDOB.getEditor().getText());
            student.setEmail(txtEmail.getText());
            student.setUsername(txtUsername.getText());
            student.setGender(rbGender.getText());
            student.setPassword(pwdPassword.getText());

            if (studentDBUtils.insertStudent(student)) {
                common.alertMessage("INFORMATION", "INFO", "Successfull", "You Have Created Student Successfully");
                showAllData();
                clearFields();
            } else {
                common.alertMessage("ERROR", "Error", "Cannot Create Sutdnet", " Student Cannot be created");

            }
        }

    }

    @FXML
    private void handleActionBtnUpdate(ActionEvent event) {
        RadioButton rbGender = (RadioButton) radioToggleGroup.getSelectedToggle();

        student = new Student();
        student.setId(Integer.parseInt(txtUserId.getText()));
        student.setName(txtName.getText());
        student.setRollNo(Integer.parseInt(txtRollNo.getText()));
        student.setFee(Double.parseDouble(txtFee.getText()));
        student.setAddress(txtAddress.getText());
        student.setSchool(txtSchool.getText());
        student.setDOB(txtDOB.getEditor().getText());
        student.setEmail(txtEmail.getText());
        student.setUsername(txtUsername.getText());
        student.setPassword(pwdPassword.getText());
        student.setGender(rbGender.getText());

        if (studentDBUtils.updateStudent(student)) {
            common.alertMessage("INFORMATION", "INFO", "Update Successfull", "You Have Updated Student Successfully");
            showAllData();
            clearFields();
        } else {
            common.alertMessage("ERROR", "Error", "Cannot Update Sutdnet", " Student Cannot be created");
        }
    }

    @FXML
    private void handleActionBtnDelete(ActionEvent event) {
        if (studentDBUtils.deleteStudent(Integer.parseInt(txtUserId.getText()))) {
            common.alertMessage("INFORMATION", "INFO", "Successfull", "Student Deleted Successfully");
            showAllData();
            clearFields();
        } else {
            common.alertMessage("ERROR", "Error", "Cannot Delete Sutdnet", " Student Cannot be Deleted");

        }
    }

    @FXML
    private void handleTblMouseClickedAction(MouseEvent event) {
        showSelectedDataFromTable();
    }

    @FXML
    private void handleTblKeyReleasedAction(KeyEvent event) {
        showSelectedDataFromTable();
    }

    @FXML
    private void hanldeMenuNewAction(ActionEvent event) {
        clearFields();
    }

    @FXML
    private void hanldeMenuLogoutAction(ActionEvent event) {
        Stage current = (Stage) btnLogout.getScene().getWindow();
        current.hide();
        common.nextWindow("/com/javatar/main/FXMLDocument.fxml", "About Page", false);
    }

    @FXML
    private void hanldeMenuExitAction(ActionEvent event) {
        Stage current = (Stage) btnLogout.getScene().getWindow();
        current.close();

    }

    @FXML
    private void hanldeMenuAboutAction(ActionEvent event) {
        common.nextWindow("/com/javatar/about/AboutPageFXML.fxml", "login", true);
    }

    @FXML
    private void handleSearchOnKeyReleased(KeyEvent event) {
        txtSearchUser.textProperty().addListener((observalbleValue, oldValue, newValue) -> {
            filteredData.setPredicate((Predicate<? super Student>) stdnt -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                Integer id = stdnt.getId();
                if (id.toString().contains(newValue)) {
                    return true;
                }
                if (stdnt.getName().toLowerCase().contains(lowerCaseFilter)) {
                    System.out.println("Student name : " + stdnt.getName());
                    return true;
                }
//                if (user.getLastName().toLowerCase().contains(lowerCaseFilter)) {
//                    return true;
//                }
                return false;
            });
        });
        SortedList<Student> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tblStudentData.comparatorProperty());
        tblStudentData.setItems(sortedData);

    }

    private void clearFields() {
        txtUserId.clear();
        txtName.clear();
        txtRollNo.clear();
        txtFee.clear();
        txtAddress.clear();
        txtSchool.clear();
        txtDOB.getEditor().clear();
        txtEmail.clear();
        txtUsername.clear();
        pwdPassword.clear();
        rdMale.setSelected(false);
        rdFemale.setSelected(false);
    }

    private void showSelectedDataFromTable() {
        clearFields();
        Student student = (Student) tblStudentData.getSelectionModel().getSelectedItem();
        txtUserId.setText("" + student.getId());
        txtName.setText(student.getName());
        txtRollNo.setText("" + student.getRollNo());
        txtFee.setText("" + student.getFee());
        txtAddress.setText(student.getAddress());
        txtSchool.setText(student.getSchool());
        txtDOB.getEditor().setText(student.getDOB());
        txtEmail.setText(student.getEmail());
        txtUsername.setText(student.getUsername());
        pwdPassword.setText(student.getPassword());
        String gender = student.getGender();

        if (gender != null) {
            if (gender.equalsIgnoreCase("male")) {
                rdMale.setSelected(true);
            } else {
                rdFemale.setSelected(true);
            }
        } else {
            rdFemale.setSelected(false);
            rdMale.setSelected(false);
        }

    }

    private void showAllData() {
        data = studentDBUtils.readStudent();
        if (data != null) {
            colId.setCellValueFactory(new PropertyValueFactory("id"));
            colName.setCellValueFactory(new PropertyValueFactory("name"));
            colRoll.setCellValueFactory(new PropertyValueFactory("rollNo"));
            colDob.setCellValueFactory(new PropertyValueFactory("DOB"));
            colFee.setCellValueFactory(new PropertyValueFactory("fee"));
            colUsername.setCellValueFactory(new PropertyValueFactory("username"));

            tblStudentData.setItems(data);
            filteredData = new FilteredList<>(data, e -> true);
        } else {
            System.out.println("No data found");
        }
    }

}
