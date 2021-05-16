package iotbay.controller;

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
import iotbay.model.dao.*;

public class ConnServlet extends HttpServlet {

    private DBConnector db;
    private DBProductManager pmanager;
    private DBCustomerManager manager;
    private DBStaffManager manager1;
    private DBSystemAdminManager manager2;
    private DBOrderManager omanager;
    private DBPaymentManager pamanager;
    private Connection conn;

    @Override //Create and instance of DBConnector for the deployment session
    public void init() {
        try {
            db = new DBConnector();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override //Add the DBConnector, DBManager, Connection instances to the session
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        conn = db.openConnection();
        try {
            pmanager = new DBProductManager(conn);
            manager = new DBCustomerManager(conn);
            manager1 = new DBStaffManager(conn);
            manager2 = new DBSystemAdminManager(conn);
            omanager = new DBOrderManager(conn);
            pamanager = new DBPaymentManager(conn);
        } catch (SQLException ex) {
            Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        //export the DB manager to the view-session (JSPs)
        session.setAttribute("pManager", pmanager);
        session.setAttribute("manager", manager);
        session.setAttribute("manager1", manager1);
        session.setAttribute("manager2", manager2);
        session.setAttribute("oManager", omanager);
        session.setAttribute("paManager", pamanager);
    }

    @Override //Destroy the servlet and release the resources of the application (terminate also the db connection)
    public void destroy() {
        try {
            db.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
