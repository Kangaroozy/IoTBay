/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.controller;

import iotbay.model.Product;
import iotbay.model.dao.DBProductManager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author Reyvaldo
 */
public class ProductListServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBProductManager manager = (DBProductManager) session.getAttribute("manager");
        String filter = request.getParameter("filter");

        try {;
            ArrayList<Product> products =  manager.searchProducts(filter);
            request.setAttribute("list",products);
            request.setAttribute("filter",filter);
            request.getRequestDispatcher("staff_prod_list.jsp").include(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ProductCreateServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBProductManager manager = (DBProductManager) session.getAttribute("manager");

        try {
            ArrayList<Product> products =  manager.fetchProducts();
            request.setAttribute("list",products);
            request.getRequestDispatcher("staff_prod_list.jsp").include(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ProductCreateServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
