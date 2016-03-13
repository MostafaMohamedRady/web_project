/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CategoriesDao;
import entity.Categories;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Aya Mahmoud
 */
public class AdminAllCategoriesController extends HttpServlet{

    CategoriesDao getCats;
    RequestDispatcher rd;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getCats = new CategoriesDao();
        ArrayList<Categories> list = (ArrayList<Categories>) getCats.selectAll();
        req.setAttribute("catsName", list);
        rd.forward(req, resp);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        rd = config.getServletContext().getRequestDispatcher("/allCategories.jsp");
    }
    
}
