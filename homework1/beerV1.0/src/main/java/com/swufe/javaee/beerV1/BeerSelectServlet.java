package com.swufe.javaee.beerV1;

import com.swufe.javaee.beerV1.model.Beer;
import com.swufe.javaee.beerV1.model.BeerExpert;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/SelectBeer.do")
public class BeerSelectServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String c = request.getParameter("color");
        BeerExpert expert = new BeerExpert();
        List<Beer> result = expert.getBrands(c);
        request.setAttribute("styles", result);
        RequestDispatcher view = request.getRequestDispatcher("/result.jsp");
        view.forward(request, response);
    }

}
