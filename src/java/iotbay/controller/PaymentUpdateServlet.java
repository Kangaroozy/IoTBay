/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.controller;

/**
 *
 * @author ASUS
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import iotbay.model.Payment;
import iotbay.model.dao.DBPaymentManager;

/**
 *
 * @author lenovo
 */
public class PaymentUpdateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        int orderID = Integer.parseInt(request.getParameter("OrderID"));
        String date = request.getParameter("Date");
        String paymentMethod = request.getParameter("PaymentMethod");
        String creditnum = request.getParameter("CreditNum");
        int cvv = Integer.parseInt(request.getParameter("CVV"));
        double paymentAmount = Double.parseDouble(request.getParameter("paymentAmount"));
        int paymentID = Integer.parseInt(request.getParameter("paymentID"));
        DBPaymentManager paManager = (DBPaymentManager) session.getAttribute("paManager");
     
        try{
                paManager.updatePayment(paymentID,paymentMethod,orderID,paymentAmount,cvv,creditnum);
                Payment payment = paManager.findPayment(paymentID);
                request.setAttribute("payment",payment);
                request.getRequestDispatcher("Update_Payment.jsp").include(request, response);
           
        }catch (SQLException ex){
            Logger.getLogger(PaymentUpdateServlet.class.getName()).log(Level.SEVERE, null, ex); 
            
        }     
      //  response.sendRedirect("updatepayment.jsp");
    }
}

