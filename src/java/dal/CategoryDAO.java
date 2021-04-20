/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Category;

/**
 *
 * @author Nam Ngoc
 */
public class CategoryDAO extends BaseDAO {

    public ArrayList<Category> getCategories() {
        ArrayList<Category> categories = new ArrayList<>();
        try {
            String sql = "SELECT * FROM dbo.Categories";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setId(rs.getInt("cid"));
                category.setName(rs.getString("cname"));
                categories.add(category);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categories;
    }
}
