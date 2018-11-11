package com.javatar.database;

import com.javatar.common.Common;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JavaConnector {

    private static Connection connection;
    static Common common = new Common();

    public static Connection createConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javastudent", "root", "system");
            return connection;
        } catch (ClassNotFoundException ex) {
            common.alertMessage("ERROR", "EXCEPTION", "ClassNotFoundException", "Check your jdbc .jar file");
            ex.printStackTrace();
        } catch (SQLException ex) {
            common.alertMessage("ERROR", "EXCEPTION", "SQLException", "Databse path, username or password didnot match with database server");
            ex.printStackTrace();

        }
        return null;
    }

  

}
