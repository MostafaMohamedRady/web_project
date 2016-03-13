/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.CartProduct;
import entity.Categories;
import entity.Product;
//import entity.ProductPK;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Aya Mahmoud
 */
/////////////////Added to handle passing product bean to single.jsp
public class SingleProductPageController extends HttpServlet{

    Product product;
   // ProductPK productPK;
    RequestDispatcher rd;
    //ServletContext context;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       /* product = (Product) req.getAttribute("product");
        String pSize = product.getProductSize();
        int pQuantitySold = product.getProductQuntitysold();
        int pQuantityAvailable = product.getProductQuntityavailable();
        float pPrice = product.getProductPrice();
        productPK = product.getProductPK();
        String pOptions = product.getProductOptions();
        String pName = product.getProductName();
        Date pModifiedDate = product.getProductLastmodify();
        //String imgPath = product.getProductImg();
        String pDescription = product.getProductDescription();
        int pCount = product.getProductCount();
        String pColor = product.getProductColor();
        Categories pCategory = product.getCategories();
        ArrayList<CartProduct> cart = (ArrayList) product.getCartProductCollection();*/
        //setting product attributes on request to forward to view
        String imgPath = "images/si.jpg";
        String pName = "product name";
        float pPrice = 500;
        String pDescription = "product description.";
        String pColor = "red";
        String pSize = "one size";
        req.setAttribute("pImage", imgPath);
        req.setAttribute("pName", pName);
        req.setAttribute("pPrice", pPrice);
        req.setAttribute("pDescription", pDescription);
        req.setAttribute("pColor", pColor);
        req.setAttribute("pSize", pSize);
        //rd = req.getRequestDispatcher("single.jsp");
        rd.forward(req, resp);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        //context = config.getServletContext();
        rd = config.getServletContext().getRequestDispatcher("/single.jsp");
    }   
}