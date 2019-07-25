package com.xpf.imoney.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Vance on 2019/07/24 :)
 * Function:
 */
@WebServlet(name = "UpdateServlet", urlPatterns = "/update")
public class UpdateServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        OutputStream out = response.getOutputStream();
        String path = getServletContext().getRealPath("/")
                + "json/update.json";
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
