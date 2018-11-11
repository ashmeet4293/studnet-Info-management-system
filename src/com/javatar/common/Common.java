
package com.javatar.common;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;


public class Common {
    
    public void nextWindow ( String fxmlPath, String title, Boolean resizable){
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
            
            Scene scene = new Scene(root);
            Stage stage= new Stage();
            
            stage.setScene(scene);
            stage.setTitle(title);
            stage.setResizable(resizable);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Common.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void alertMessage(String type,String title, String headerText,String content){
        Alert alert= new Alert(Alert.AlertType.valueOf(type));
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(content);
        alert.showAndWait();
        
    }
    
}   
