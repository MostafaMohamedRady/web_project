/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CartProductDao;
import dao.ProductDao;
import dao.ProductPKDao;
import entity.CartProduct;
import entity.Product;
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
public class AddToCardController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddToCardController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddToCardController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        CartProduct cartProduct=new CartProduct();
        Users user=new Users();
        
        CartProductDao cpd=new CartProductDao();
        HttpSession session=request.getSession(false);
        if(session==null)
        {
            response.sendRedirect("login.jsp");
        }
        else
        {
            user=(Users) session.getAttribute("user");            
          //  cartProduct.setProduct(request.getParameter("idproduct"));
            cartProduct.setCartProductMount(Integer.parseInt(request.getParameter("productMount")));
            cartProduct.setUsersIdusers(user);
            cartProduct.setCartProductDate(null);
            cartProduct.setPaymentIdpayment(null);
        //    request.getParameter("productColor");
        //    request.getParameter("productSize");
            int insert = cpd.insert(cartProduct);
            if (insert>0){
                ProductPKDao productDao=new ProductPKDao();
                Product p=new Product();
                p.setIdproduct(0);
                p.setProductQuntityavailable(0);
                productDao.update(p);
                response.sendRedirect(null);
            }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
