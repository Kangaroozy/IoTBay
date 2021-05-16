/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.controller;

import iotbay.model.Payment;

import iotbay.model.dao.DBPaymentManager;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import iotbay.model.dao.DBConnector;



public class FindPaymentServlet extends HttpServlet {

   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
       HttpSession session = request.getSession();
        Validator validator = new Validator();
       int paymentID = Integer.parseInt(request.getParameter("paymentID"));
       String date = request.getParameter("paymentDate");
       
       DBPaymentManager paManager = (DBPaymentManager) session.getAttribute("paManager");
       Payment payment = null;
       session.setAttribute ("payment", null);
       session.setAttribute("searchErr", null);
       //validator.clear(session);
       
       if (!validator.validateDate(date)) {
           session.setAttribute("dateErr", "Date is invalid! Follow: dd/mm/yyyy");
           request.getRequestDispatcher("payment.jsp").include(request,response);
        }
         
       
       else {
           try {
               payment = paManager.findPayment(paymentID);
               if (payment != null) {
                   session.setAttribute("payment", payment);
                   
                   request.getRequestDispatcher("payment.jsp").include(request, response);
                   
               } else {
                   session.setAttribute("searchErr", "Payment does not exist in the Database! Please try again.");
                   request.getRequestDispatcher("payment.jsp").include(request, response);
               }
           } catch (SQLException ex) {
               Logger.getLogger(FindPaymentServlet.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
   }
}