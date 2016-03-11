/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UsersDao;
import entity.Users;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Bakar M.M.R
 */
public class LoginController extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UserLogin</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserLogin at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Users user=new Users();
        String mail=request.getParameter("userEmail");
        String pass=request.getParameter("userPassword");
       
        user.setUserEmail(request.getParameter("userEmail"));
        user.setUserPassword(request.getParameter("userPassword"));
       
        UsersDao userDao = new UsersDao();
        Users check = userDao.login(user);
        if (check !=null) {
            HttpSession session=request.getSession(true);
            session.setAttribute("user", user);
            System.out.println(user.getUserEmail()+"/"+user.getUserName());
            
            request.getSession().setAttribute("name", check);  
            request.getSession().setAttribute("email", check);
            request.getSession().setAttribute("ssn", check);
            request.getSession().setAttribute("charge", check);
            response.sendRedirect("profile.jsp");
        } else {
            response.sendRedirect("login.jsp");
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
