package iotbay.model.dao;

import java.sql.Connection;

/**
 *
 * @author 13725
 */
public abstract class DB {

    protected String URL = "jdbc:derby://localhost:1527/";
    protected String db = "LOTBAY";  
    protected String dbuser = "lotbayuser"; 
    protected String dbpass = "123456"; 
    protected String driver = "org.apache.derby.jdbc.ClientDriver";
    protected Connection conn;

}
