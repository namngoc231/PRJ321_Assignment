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
import model.Cat;
import model.Category;

/**
 *
 * @author Nam Ngoc
 */
public class CatDAO extends BaseDAO {

// get cat by cid, pageIndex,pageSize
    public ArrayList<Cat> getCatsByCid(int cid, int pageIndex, int pageSize) {
        ArrayList<Cat> cats = new ArrayList<>();
        try {
            String sql = "WITH r AS (SELECT ROW_NUMBER() OVER (ORDER BY pid DESC) rownum, pid, pname, pprice, pthumbnail FROM dbo.Products WHERE cid = ?) "
                    + "SELECT * FROM r WHERE r.rownum >= (? - 1) * ? + 1 AND r.rownum <= ? * ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, cid);
            st.setInt(2, pageIndex);
            st.setInt(3, pageSize);
            st.setInt(4, pageIndex);
            st.setInt(5, pageSize);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Cat cat = new Cat();
                cat.setId(rs.getInt("pid"));
                cat.setName(rs.getString("pname"));
                cat.setPrice(rs.getFloat("pprice"));
                cat.setThumbnail(rs.getString("pthumbnail"));
                cats.add(cat);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CatDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cats;
    }
// get total cats of Products by cid of Category

    public int getTotalCatsByCid(int cid) {
        int cnt = 0;
        try {
            String sql = "SELECT COUNT(*) total FROM dbo.Products WHERE cid = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, cid);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                cnt = rs.getInt("total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CatDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cnt;
    }
// get cat by pageIndex,pageSize

    public ArrayList<Cat> getAllProducts(int pageIndex, int pageSize) {
        ArrayList<Cat> cats = new ArrayList<>();
        try {
            String sql = "WITH r AS (SELECT ROW_NUMBER() OVER (ORDER BY pid DESC) rownum, pid, pname, c.cid, c.cname, pprice, pthumbnail FROM dbo.Products p INNER JOIN dbo.Categories c ON c.cid = p.cid) SELECT * FROM r WHERE r.rownum >= (? - 1) * ? + 1 AND r.rownum <= ? * ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, pageIndex);
            st.setInt(2, pageSize);
            st.setInt(3, pageIndex);
            st.setInt(4, pageSize);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Cat cat = new Cat();
                cat.setId(rs.getInt("pid"));
                cat.setName(rs.getString("pname"));
                cat.setPrice(rs.getFloat("pprice"));
                cat.setThumbnail(rs.getString("pthumbnail"));
                Category c = new Category();
                c.setId(rs.getInt("cid"));
                c.setName(rs.getString("cname"));
                cat.setCategory(c);
                cats.add(cat);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CatDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cats;
    }
// get total cats of product

    public int getTotalCats() {
        int cnt = 0;
        try {
            String sql = "SELECT COUNT(*) total FROM dbo.Products";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                cnt = rs.getInt("total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CatDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cnt;
    }
// get cat by keyword, pageIndex,pageSize

    public ArrayList<Cat> getCatsByKeyword(String keyword, int pageIndex, int pageSize) {
        ArrayList<Cat> cats = new ArrayList<>();
        try {
            String sql = "WITH r AS (SELECT ROW_NUMBER() OVER (ORDER BY pid DESC) rownum, pid, pname, pprice, pthumbnail FROM dbo.Products WHERE pname LIKE '%' + ? + '%') SELECT * FROM r WHERE r.rownum >= (? - 1) * ? + 1 AND r.rownum <= ? * ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setNString(1, keyword);
            st.setInt(2, pageIndex);
            st.setInt(3, pageSize);
            st.setInt(4, pageIndex);
            st.setInt(5, pageSize);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Cat cat = new Cat();
                cat.setId(rs.getInt("pid"));
                cat.setName(rs.getString("pname"));
                cat.setPrice(rs.getFloat("pprice"));
                cat.setThumbnail(rs.getString("pthumbnail"));
                cats.add(cat);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CatDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cats;
    }
// get total cats by keyword: use for search

    public int getTotalCatsByKeyword(String keyword) {
        int cnt = 0;
        try {
            String sql = "SELECT COUNT(*) total FROM dbo.Products WHERE pname LIKE '%' + ? + '%'";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, keyword);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                cnt = rs.getInt("total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CatDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cnt;
    }
// get cats by id

    public Cat getCatByID(int id) {
        try {
            String sql = "SELECT p.*, c.cname FROM dbo.Products p INNER JOIN dbo.Categories c ON c.cid = p.cid WHERE pid = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Cat cat = new Cat();
                cat.setId(id);
                cat.setName(rs.getString("pname"));
                cat.setShortDesc(rs.getString("pshortdesc"));
                cat.setPrice(rs.getFloat("pprice"));
                cat.setDesc(rs.getString("pdesc"));
                cat.setThumbnail(rs.getString("pthumbnail"));
                Category category = new Category();
                category.setId(rs.getInt("cid"));
                category.setName(rs.getString("cname"));
                cat.setCategory(category);
                return cat;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CatDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
// get 4 cat latest by pid DESC

    public ArrayList<Cat> getTop4Latest() {
        ArrayList<Cat> cats = new ArrayList<>();
        try {
            String sql = "SELECT TOP 4 * FROM Products ORDER BY pid DESC";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Cat cat = new Cat();
                cat.setId(rs.getInt("pid"));
                cat.setName(rs.getString("pname"));
                cat.setPrice(rs.getFloat("pprice"));
                cat.setThumbnail(rs.getString("pthumbnail"));
                cats.add(cat);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CatDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cats;
    }

    public boolean delete(int cid) {
        try {
            String sql = "DELETE FROM dbo.Products WHERE pid = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, cid);
            return st.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(CatDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean insert(Cat cat) {
        try {
            String sql = "INSERT INTO dbo.Products\n"
                    + "        ( pname ,\n"
                    + "          pprice ,\n"
                    + "          pshortdesc ,\n"
                    + "          pdesc ,\n"
                    + "          pthumbnail ,\n"
                    + "          cid\n"
                    + "        )\n"
                    + "VALUES  (?, ?, ?, ?, ?, ?)";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, cat.getName());
            st.setFloat(2, cat.getPrice());
            st.setString(3, cat.getShortDesc());
            st.setString(4, cat.getDesc());
            st.setString(5, cat.getThumbnail());
            st.setInt(6, cat.getCategory().getId());
            return st.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(CatDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean update(Cat cat) {
        try {
            String sql = "UPDATE dbo.Products SET pname = ?, pprice = ?, pshortdesc = ?, pdesc = ?, pthumbnail = ?, cid = ? WHERE pid = ? ";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, cat.getName());
            st.setFloat(2, cat.getPrice());
            st.setString(3, cat.getShortDesc());
            st.setString(4, cat.getDesc());
            st.setString(5, cat.getThumbnail());
            st.setInt(6, cat.getCategory().getId());
            st.setInt(7, cat.getId());
            return st.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(CatDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
