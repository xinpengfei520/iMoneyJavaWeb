package com.xpf.imoney.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private static String username = "13212341234";
    // MD5加密字符串(密码是123456)
    private static String password = "e10adc3949ba59abbe56e057f20f883e";

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
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //String sql = "select username,imageurl from user_table where username = ? and password = ?"
        OutputStream out = response.getOutputStream();
        if (this.username.equals(username) && this.password.equals(password)) {
            // 登录成功：返回登录信息
            String path = getServletContext().getRealPath("/")
                    + "json/login.json";
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
        } else {
            // 登录失败
            String jsonError = "{\"success\":false}";
            out.write(jsonError.getBytes());
            out.flush();
            out.close();
        }
    }

}
