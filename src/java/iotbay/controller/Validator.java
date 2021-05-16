/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package iotbay.controller;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpSession;

public class Validator implements Serializable {
    private String emailPattern = "([a-zA-Z0-9]+)(([._-])([a-zA-Z0-9]+))*(@)([a-z]+)(.)([a-z]{3})((([.])[a-z]{0,2})*)";
    private String namePattern = "([A-Z][a-z]+)";
    private String passwordPattern = "[a-z0-9]{4,}";
    private String datePattern = "[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$";  

    public Validator() {
    }

    public boolean validate(String pattern, String input) {
        Pattern regEx = Pattern.compile(pattern);
        Matcher match = regEx.matcher(input);

        return match.matches();
    }

    public boolean checkEmpty(String email, String password) {
        return email.isEmpty() || password.isEmpty();
    }

    public boolean validateEmail(String email) {
        return validate(emailPattern, email);
    }

    public boolean validateFirstName(String firstname) {
        return validate(namePattern, firstname);
    }

    public boolean validateLastName(String lastname) {
        return validate(namePattern, lastname);
    }
    
    public boolean validatePassword(String password) {
        return validate(passwordPattern, password);
    }

    public void clear(HttpSession session) {
        session.setAttribute("emailErr", "Enter email");
        session.setAttribute("passErr", "Enter password");
        session.setAttribute("existErr", "");
        session.setAttribute("nameErr", "Enter name");
    }

    public boolean validatePositive(double number) {
        if (number >= 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validateStringFilled(String string) {
        if (string.length() > 0) {
            return true;
        } else {
            return false;
        }
    }
    
       public boolean validateDate(String date){                       
      return validate(datePattern,date);   

   }
}
