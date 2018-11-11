/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javatar.main;

import com.javatar.common.Common;
import com.javatar.database.StudentDBUtils;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author ozzy gurung
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField pwdPassword;
    @FXML
    private Label lblStatus;
    @FXML
    private ComboBox<String> cmbLoginType;

    Common common = new Common();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cmbLoginType.getItems().addAll("admin", "user");
        cmbLoginType.getSelectionModel().selectFirst();

    }

    @FXML
    private void handleLoginAction(ActionEvent event) {
        String username = txtUsername.getText();
        String password = pwdPassword.getText();
        String loginType = cmbLoginType.getSelectionModel().getSelectedItem();

        StudentDBUtils studentDBUtils = new StudentDBUtils();
        if (studentDBUtils.login(username, password)) {
            Stage current = (Stage) txtUsername.getScene().getWindow();
            current.hide();
            common.nextWindow("/com/javatar/dashboard/DashboardFXML.fxml", "Dashboard", true);
        } else {
          common.alertMessage("ERROR", "Cannot Login", "Wrong Credentials", "Your username or password is incorrect");
        }

    }
}
