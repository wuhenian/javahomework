package com.example.HW_2;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SelectBeerServlet", value = "/SelectBeerServlet")
public class SelectBeerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String body = request.getParameter("body");
        int amount = Integer.parseInt(request.getParameter("amount")) ;
        String[] sizes = request.getParameterValues("sizes");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>This is your selection</h1>");
        out.println("<p>body: " + body + "</p>");
        out.println("<p>amount: " + amount + "</p>");
        for (String s : sizes) {
            out.println("<p>sizes: " + s + "</p>");
        }
        out.println("</body></html>");
    }
}
