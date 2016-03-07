/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author Bakar M.M.R
 */
public class DBConnectListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            String url = "jdbc:mysql://localhost:3306/web_project";
            String user = "root";
            String password = "";
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement statement=connection.prepareStatement("");
            sce.getServletContext().setAttribute("statement", statement);
            System.out.println("DB on Context");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnectListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
