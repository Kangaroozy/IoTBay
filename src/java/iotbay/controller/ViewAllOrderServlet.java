/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.controller;

import iotbay.model.Order;
import iotbay.model.Customer;
import iotbay.model.dao.DBOrderManager;
import java.io.IOException;
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

/**
 *
 * @author joshcelik-alvis
 */
public class ViewAllOrderServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBOrderManager oManager = (DBOrderManager) session.getAttribute("oManager");
        Customer cust = (Customer) session.getAttribute("customer");
        String uid = Integer.toString(cust.getUserID());
        String filter = request.getParameter("filter");

        try {
            ArrayList<Order> orders = oManager.searchOrder(filter);
            request.setAttribute("list", orders);
            request.setAttribute("filter", filter);
            request.getRequestDispatcher("view_all_order.jsp").include(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ViewAllOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBOrderManager oManager = (DBOrderManager) session.getAttribute("oManager");
        Customer cust = (Customer) session.getAttribute("customer");
        String uid = Integer.toString(cust.getUserID());

        try {
            ArrayList<Order> orders = oManager.fetchOrders();
            request.setAttribute("list", orders);
            request.getRequestDispatcher("view_all_order.jsp").include(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ViewAllOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}