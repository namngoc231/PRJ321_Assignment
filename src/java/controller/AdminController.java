/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.CatDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Cat;
import model.User;

/**
 *
 * @author Nam Ngoc
 */
public class AdminController extends BaseAuthController {

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user.isAdmin()) {
            String page = request.getParameter("page");
            page = (page == null || page.trim().isEmpty()) ? "1" : page;
            int pageIndex = Integer.parseInt(page);
            int pageSize = 9;
            CatDAO catDB = new CatDAO();
            int totalCats = catDB.getTotalCats();
            int totalPages = totalCats % pageSize == 0 ? totalCats / pageSize : totalCats / pageSize + 1;
            ArrayList<Cat> products = catDB.getAllProducts(pageIndex, pageSize);
            request.setAttribute("totalCats", totalCats);
            request.setAttribute("pageIndex", pageIndex);
            request.setAttribute("totalPages", totalPages);
            request.setAttribute("products", products);
            request.getRequestDispatcher("admin.jsp").forward(request, response);
        } else {
            response.sendRedirect("index");
        }
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

}
