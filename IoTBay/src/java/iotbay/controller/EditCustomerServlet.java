package iotbay.controller;

import com.sun.istack.logging.Logger;
import customer.Customer;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import iotbay.model.dao.DBCustomerManager;
import iotbay.model.*;
import java.sql.SQLException;
import java.util.logging.Level;


/**
 *
 * @author 13725
 */
public class EditCustomerServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        DBCustomerManager manager = (DBCustomerManager) session.getAttribute("manager");
        
        Customer customer = null;
        try {
            customer = manager.findCustomer(email,password);
            if (customer != null) {
                session.setAttribute("customer",customer);
                request.getRequestDispatcher("edit.jsp").include(request, response);                                        
            } else {
                session.setAttribute("existErr", "Customer does not exist in the Database!");
                request.getRequestDispatcher("edit.jsp").include(request, response);                
            }
        } catch(SQLException ex){
            Logger.getLogger(EditCustomerServlet.class.getName()).log(Level.SEVERE,null,ex);          
        }
        request.getRequestDispatcher("edit.jsp").include(request, response);
    }
}

