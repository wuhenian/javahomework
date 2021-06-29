package com.library.servlet;

import com.library.entity.User;
import com.library.utils.UserUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "RegisterServlet", value = "/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/register.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String unum = request.getParameter("unum").trim();
        String upass = request.getParameter("upass").trim();
        String uname = request.getParameter("uname").trim();
        List<User> users = UserUtils.loadUser();
        for (User user : users) {
            if (user.getUnum().equals(unum)) {
                response.sendRedirect("/register-error.html");
                return;
            }
        }
        if (UserUtils.addUser(unum, uname, upass)) {
            response.sendRedirect("/register-success.html");
        } else {
            response.sendRedirect("/register-error.html");
        }
    }
}
