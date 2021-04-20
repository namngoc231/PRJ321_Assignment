/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.CatDAO;
import dal.CategoryDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cat;
import model.Category;

/**
 *
 * @author Nam Ngoc
 */
public class CreateController extends BaseAuthController {

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryDAO cateDb = new CategoryDAO();
        ArrayList<Category> categories = cateDb.getCategories();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("create.jsp").forward(request, response);
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        Float price = Float.parseFloat(request.getParameter("price"));
        String image = request.getParameter("image");
        String shortDesc = request.getParameter("shortDesc");
        String desc = request.getParameter("desc");
        int category = Integer.parseInt(request.getParameter("category"));
        Cat cat = new Cat();
        cat.setName(name);
        cat.setPrice(price);
        cat.setShortDesc(shortDesc);
        cat.setDesc(desc);
        cat.setThumbnail(image);
        Category c = new Category();
        c.setId(category);
        cat.setCategory(c);
        CatDAO catDB = new CatDAO();
        boolean isInserted = catDB.insert(cat);
        if (isInserted) {
            response.sendRedirect("admin");
        } else {
            response.getWriter().println("Insert Failed!");
        }
    }

}
