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
 * Function:动漫仓
 */
@WebServlet(name = "ComicStoreServlet", urlPatterns = "/ComicStore")
public class ComicStoreServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OutputStream os = response.getOutputStream();
        String path = getServletContext().getRealPath("/") + "shopping/COMIC_STORE.json";
        File file = new File(path);
        FileInputStream fis = new FileInputStream(file);
        int count = -1;
        byte[] buffer = new byte[1024];
        while ((count = fis.read(buffer)) != -1) {
            os.write(buffer, 0, count);
            os.flush();
        }
        fis.close();
        os.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
