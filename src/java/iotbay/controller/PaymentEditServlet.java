/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.controller;

import iotbay.model.Payment;
import iotbay.model.dao.DBPaymentManager;
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
 * @author Reyvaldo
 */
public class PaymentEditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBPaymentManager paManager = (DBPaymentManager) session.getAttribute("paManager");
        int PayID = Integer.parseInt(request.getParameter("ID"));

        try {
            Payment payment = paManager.findPayment(PayID);
            request.setAttribute("payment", payment);
            request.getRequestDispatcher("Update_Payment.jsp").include(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(PaymentEditServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}