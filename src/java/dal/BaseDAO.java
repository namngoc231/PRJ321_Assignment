/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nam Ngoc
 */
public abstract class BaseDAO {

    Connection connection;

    public BaseDAO() {
        try {
            String user = "sa";
            String pass = "123";
            String db = "Project";
            String url = "jdbc:sqlserver://localhost:1433;databaseName=" + db;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, user, pass);
        } catch (Exception ex) {
            Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
