package com.example.UploadImage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UploadServlet", value = "/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final Part filePart = request.getPart("file");
        String s1 = filePart.getSubmittedFileName();
        filePart.write("F:\\javahw-main\\HW2\\UploadImage\\src\\main\\webapp\\img\\" + s1);
        response.sendRedirect("success.html");
    }
}
