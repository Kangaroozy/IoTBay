package iotbay.controller;

import customer.Customer;
import iotbay.model.dao.DBCustomerManager;
import static java.util.logging.Level.SEVERE;
import java.io.IOException;
import java.sql.SQLException;
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
public class UpdateCustomerServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        HttpSession session = request.getSession();
        String Firstname = request.getParameter("Firstname");
        String Lastname = request.getParameter("Lastname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");
        String phonenumber = request.getParameter("phonenumber");
        String dob = request.getParameter("dob");
        Customer customer = new Customer(USERID,Firstname, Lastname, email, password, gender, address, phonenumber,dob);
        DBCustomerManager manager = (DBCustomerManager) session.getAttribute("manager");
        try{
            if (customer != null){
                session.setAttribute("customer",customer);
                manager.updateCustomer( Firstname, Lastname, email, password, gender, address, phonenumber,dob);
                session.setAttribute("updated","Update was successful");
                request.getRequestDispatcher("edit.jsp").include(request, response);
            }else{
                session.setAttribute("update", "Update was not successful!");
                request.getRequestDispatcher("edit.jsp").include(request, response);
;            }
        } catch (SQLException ex) {
            Logger.getLogger(EditCustomerServlet.class.getName()).log(Level,SEVERE, null, ex);            
        }
        response.sendRedirect("edit.jsp");
    }
}

