package iotbay.controller;

import customer.Customer;
import iotbay.model.dao.DBCustomerManager;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
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
 * @author 13725
 */
public class CreateCustomerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");
        String DOB = request.getParameter("DOB");
        String phonenumber = request.getParameter("phonenumber");
        DBCustomerManager manager = (DBCustomerManager) session.getAttribute("manager");
        Validator validator = new Validator();
        Customer customer = (Customer) session.getAttribute("customer");
        
                try {
            manager.addCustomer(firstname,lastname,email,password,address,DOB,phonenumber);
            
            response.sendRedirect("CustomerViewServlet");
        } catch (SQLException ex) {
            Logger.getLogger(CreateCustomerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try{
            manager.addCustomer(firstname, lastname, email, password, address,DOB, phonenumber);
            int customerID = manager.addCustomer(firstname, lastname, email,password, address, DOB, phonenumber).getcustomerID();
                response.sendRedirect("CustomerViewServlet");
            } catch (SQLException ex) {
                Logger.getLogger(CreateCustomerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
