/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
public class CartController extends BaseAuthController {

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rid = request.getParameter("removeId");
        if (rid != null && !rid.trim().isEmpty()) {
            int removeId = Integer.parseInt(rid);
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            ArrayList<Cat> catList = user.getCatList();
            Cat cat = new Cat();
            for (Cat c : catList) {
                if (c.getId() == removeId) {
                    cat = c;
                    break;
                }
            }
            boolean isRemoved = catList.remove(cat);
            if (isRemoved) {
                response.sendRedirect("cart");
            }
        } else {
            request.getRequestDispatcher("cart.jsp").forward(request, response);
        }
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
