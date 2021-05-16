/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.controller;

import iotbay.model.Customer;
import java.io.IOException;
import iotbay.model.dao.*;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author joshcelik-alvis
 */
public class CreatePaymentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator =new Validator();
        DBPaymentManager paManager = (DBPaymentManager) session.getAttribute("paManager");
        int orderID = Integer.parseInt(request.getParameter("OrderID"));
        String date = request.getParameter("Date");
        String paymentMethod = request.getParameter("PaymentMethod");
        String creditnum = request.getParameter("CreditNum");
        int cvv = Integer.parseInt(request.getParameter("CVV"));
        double paymentAmount = Integer.parseInt(request.getParameter("paymentAmount"));
        int paymentID = Integer.parseInt(request.getParameter("paymentID"));
        
        Customer customer = (Customer) session.getAttribute("customer");

        if(!validator.validateDate(date)){
            session.setAttribute("dateErr","Date format incorrect");
            request.getRequestDispatcher("addpayment.jsp").include(request, response);
            
        }else{
            try {
                
            paManager.addPayment(orderID,paymentID,paymentAmount, paymentMethod,cvv,creditnum );
            paManager.updatePayment(paymentID,paymentMethod,orderID,paymentAmount,cvv,creditnum);
            request.setAttribute("value", paymentID);
            request.getRequestDispatcher("Create_Payment.jsp").include(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CreatePaymentServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
