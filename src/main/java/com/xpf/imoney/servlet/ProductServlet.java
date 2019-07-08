package com.xpf.imoney.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ProductServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // request.setCharacterEncoding("utf-8");
        // response.setCharacterEncoding("UTF-8");
        // response.setContentType("text/html");
        // response.setHeader("content-type","text/html;charset=UTF-8");
        OutputStream out = response.getOutputStream();
        String path = getServletContext().getRealPath("/")
                + "json/product.json";
        File file = new File(path);
        FileInputStream stream = new FileInputStream(file);
        int count = -1;
        byte[] buffer = new byte[1024];
        while ((count = stream.read(buffer)) != -1) {
            out.write(buffer, 0, count);
            out.flush();
        }
        stream.close();
        out.close();
    }

}
