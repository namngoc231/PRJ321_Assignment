/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

/**
 *
 * @author Nam Ngoc
 */
public class UserDAO extends BaseDAO {

    public User getUser(String username, String password) {
        try {
            String sql = "SELECT * FROM dbo.Users WHERE userName = ? AND password = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("uid"));
                user.setFullName(rs.getString("fullName"));
                user.setUserName(rs.getString("userName"));
                user.setEmail(rs.getString("email"));
                user.setAddress(rs.getString("address"));
                user.setPhoneNumber(rs.getString("phoneNumber"));
                user.setAdmin(rs.getBoolean("isAdmin"));
                return user;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean addUser(User user) {
        try {
            String sql = "INSERT INTO dbo.Users(fullName, address, userName, password, email, phoneNumber, isAdmin) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, user.getFullName());
            st.setString(2, user.getAddress());
            st.setString(3, user.getUserName());
            st.setString(4, user.getPassword());
            st.setString(5, user.getEmail());
            st.setString(6, user.getPhoneNumber());
            st.setBoolean(7, user.isAdmin());
            return st.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
