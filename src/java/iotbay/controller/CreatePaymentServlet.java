/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.controller;

import iotbay.model.Payment;
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
        
        int orderID = Integer.parseInt(request.getParameter("OrderID"));
        
        String date = request.getParameter("Date");
        String paymentMethod = request.getParameter("PaymentMethod");
        String creditnum = request.getParameter("CreditNum");
        int cvv = Integer.parseInt(request.getParameter("CVV"));
        double paymentAmount = Double.parseDouble(request.getParameter("paymentAmount"));
        DBPaymentManager pamanager = (DBPaymentManager) session.getAttribute("pamanager");
        validator.clear(session);
        
            try {
            pamanager.addPayment(date,orderID,paymentAmount, paymentMethod,cvv,creditnum );
            Payment payment = new Payment(date,paymentMethod,paymentAmount,orderID, cvv,creditnum);
            session.setAttribute("Payment",payment);
            request.getRequestDispatcher("Payment.jsp").include(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CreatePaymentServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    
}
