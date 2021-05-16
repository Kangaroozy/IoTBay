package iotbay.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author 13725
 */
public class DBConnector extends DB{
    
        public DBConnector() throws ClassNotFoundException, SQLException{
            Class.forName(driver);
            super.conn = DriverManager.getConnection(URL + db, dbuser,dbuser);
        }
    public Connection connection(){
        return this.conn;       
    }
    
    public void closeConnection() throws SQLException{
        this.conn.close();
    }
}

