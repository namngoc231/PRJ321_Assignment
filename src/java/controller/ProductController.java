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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Cat;
import model.User;

/**
 *
 * @author Nam Ngoc
 */
public class ProductController extends HttpServlet {

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
        String pid = request.getParameter("id");
        if (pid == null || pid.trim().isEmpty()) {
            response.sendRedirect("store");
        } else {
            int id = Integer.parseInt(pid);
            CatDAO catDB = new CatDAO();
            Cat cat = catDB.getCatByID(id);
            request.setAttribute("cat", cat);
            request.getRequestDispatcher("product.jsp").forward(request, response);
        }
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
                HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        ArrayList<Cat> catList = user.getCatList();
        String catid = request.getParameter("id");
        int id = Integer.parseInt(catid);
        String q = request.getParameter("quantity");
        int quantity = Integer.parseInt(q);
        CatDAO catDB = new CatDAO();
        Cat cat = new Cat();
        boolean isExisted = false;
        for (Cat c : catList) {
            if (c.getId() == id) {
                cat = c;
                isExisted = true;
                break;
            }
        }
        if (isExisted) {
            cat.setQuantity(cat.getQuantity() + quantity);
        } else {
            cat = catDB.getCatByID(id);
            cat.setQuantity(quantity);
            catList.add(cat);
        }
        response.sendRedirect("product?id=" + id);
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
