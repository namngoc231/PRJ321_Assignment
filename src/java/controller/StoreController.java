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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cat;
import model.Category;

/**
 *
 * @author Nam Ngoc
 */
public class StoreController extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CatDAO catDB = new CatDAO();
        String page = request.getParameter("page");
        page = (page == null || page.trim().isEmpty()) ? "1" : page;
        int pageIndex = Integer.parseInt(page);
        int pageSize = 9;
        int totalRecords = -1;
        String category = request.getParameter("cid");
        ArrayList<Cat> cats = new ArrayList<>();
        if (category != null && !category.trim().isEmpty()) {
            int cateid = Integer.parseInt(category);
            cats = catDB.getCatsByCid(cateid, pageIndex, pageSize);
            totalRecords = catDB.getTotalCatsByCid(cateid);
            request.setAttribute("cateid", cateid);
        } else {
            cats = catDB.getAllProducts(pageIndex, pageSize);
            totalRecords = catDB.getTotalCats();
        }
        int totalPages = (totalRecords % pageSize == 0) ? (totalRecords / pageSize) : (totalRecords / pageSize + 1);
        request.setAttribute("totalRecords", totalRecords);
        request.setAttribute("pageIndex", pageIndex);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("cats", cats);
        CategoryDAO categoryDB = new CategoryDAO();
        ArrayList<Category> categories = categoryDB.getCategories();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("store.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
