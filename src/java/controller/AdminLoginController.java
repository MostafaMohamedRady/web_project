/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

/**
 *
 * @author Aya Mahmoud
 */
public class AdminLoginController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user="";
        String pwd="";
        String username = (String) req.getParameter("user");
        String password = (String) req.getParameter("pwd");
        
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new File("adminLogin.xml"));
            user = doc.getElementsByTagName("username").item(0).getFirstChild().getNodeValue();
            pwd = doc.getElementsByTagName("password").item(0).getFirstChild().getNodeValue();
        } catch (Exception ex) {
            Logger.getLogger(AdminLoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

        if(user.equals(username) && pwd.equals(password))
        {
            RequestDispatcher rd = req.getRequestDispatcher("/adminhome");
            rd.forward(req, resp);
        }
        else
        {
            //PrintWriter writer = resp.getWriter();
            //writer.println("<p style=\"color:red\">please enter admin username and password</p>");
            //String error = "<p style=\"color:red\">please enter admin username and password</p>";
            //req.setAttribute("error", error);
            RequestDispatcher rd = req.getRequestDispatcher("/adminLogin.jsp");
            rd.forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/adminLogin.jsp");
        rd.forward(req, resp);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        //rd = config.getServletContext().getRequestDispatcher("/adminLogin.jsp");
    }
    
}
