/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.controller;

import iotbay.model.Payment;
import iotbay.model.dao.DBPaymentManager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
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
public class DeletePaymentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBPaymentManager paManager = (DBPaymentManager) session.getAttribute("paManager");
        int paymentID = Integer.parseInt(request.getParameter("paymentID"));

        try {
            paManager.deletePayment(paymentID);
            response.sendRedirect("PaymentListServlet");
        } catch (SQLException ex) {
            Logger.getLogger(CreatePaymentServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}