/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.UserDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;

/**
 *
 * @author Nam Ngoc
 */
public class LoginController extends HttpServlet {

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

        Cookie[] cookies = request.getCookies();
        boolean hasAccount = false;
        if (cookies != null) {
            String username = null;
            String password = null;

            for (Cookie cooky : cookies) {
                if (cooky.getName().equals("username1")) {
                    username = cooky.getValue();
                }
                if (cooky.getName().equals("password1")) {
                    password = cooky.getValue();
                }
            }

            if (username != null && password != null) {
                hasAccount = true;
            }
        }
        if (hasAccount) {
            response.sendRedirect("index");
        } else {
            request.getRequestDispatcher("login.jsp").forward(request, response);
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
 
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");
        UserDAO userDB = new UserDAO();
        User user = userDB.getUser(username, password);
        
        if (user!=null) {
            //login successfully
            if (remember != null) {
                Cookie cookie_user = new Cookie("username1", username);
                Cookie cookie_pass = new Cookie("password1", password);

                cookie_user.setMaxAge(3600);
                cookie_pass.setMaxAge(3600);
                
                response.addCookie(cookie_user);
                response.addCookie(cookie_pass);
                
            }
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect("index");

        } else {
            //Login failed
            request.setAttribute("errorMsg", "Username / Password Incorrect!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
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
