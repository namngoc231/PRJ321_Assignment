/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.CatDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nam Ngoc
 */
public class DeleteController extends BaseAuthController {

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id != null && !id.trim().isEmpty()) {
            int pid = Integer.parseInt(id);
            CatDAO catDB = new CatDAO();
            boolean isDeleted = catDB.delete(pid);
            if (isDeleted) {
                response.sendRedirect("admin");
            } else {
                response.getWriter().println("Delete Failed!");
            }
        }
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

}
