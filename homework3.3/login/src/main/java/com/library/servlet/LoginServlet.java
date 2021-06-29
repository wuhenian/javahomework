package com.library.servlet;

import com.library.entity.User;
import com.library.utils.UserUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/Login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String number = request.getParameter("number").trim();
        String pwd = request.getParameter("password").trim();
            User user = UserUtils.getUserByNumAndPass(number, pwd);
            if (user == null) {
                response.sendRedirect("/login-error.html");
            } else {
                request.getSession().setAttribute("user", user);
                response.sendRedirect("/loginsuccess.html");
            }
        }
    }

