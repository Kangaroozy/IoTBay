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
 * @author Reyvaldo
 */
public class PaymentListServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBPaymentManager paManager = (DBPaymentManager) session.getAttribute("paymentManager");
        String filter = request.getParameter("filter");
        String dates = request.getParameter("date");
        int PayID = Integer.parseInt(request.getParameter("paymentID"));

        try {
            ArrayList<Payment> payments = paManager.searchPayment(dates);
            request.setAttribute("list", payments);
            request.setAttribute("filter", filter);
            request.setAttribute("paymentID", PayID);
            if (dates.equals("")) {
                request.setAttribute("date", "ALL");
            }
            request.setAttribute("date", dates);
            request.getRequestDispatcher("payment.jsp").include(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(PaymentListServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBPaymentManager paManager = (DBPaymentManager) session.getAttribute("paymentManager");
        String dates = request.getParameter("date");
        try {
            ArrayList<Payment> payments = paManager.fetchPayment();
            request.setAttribute("list", payments);
            request.setAttribute("date", dates);
            request.getRequestDispatcher("payment.jsp").include(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(PaymentListServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}