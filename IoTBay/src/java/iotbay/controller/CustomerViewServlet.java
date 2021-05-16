package iotbay.controller;

import customer.Customer;
import iotbay.model.dao.DBCustomerManager;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 137250
 */
public class CustomerViewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBCustomerManager manager = (DBCustomerManager) session.getAttribute("manager");
        int customerID = Integer.parseInt(request.getParameter("USERID"));

        try {
            Customer customers = manager.findCustomer(email, password);
            request.setAttribute("customer", customers);
            request.getRequestDispatcher("customer.jsp").include(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CreateCustomerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}