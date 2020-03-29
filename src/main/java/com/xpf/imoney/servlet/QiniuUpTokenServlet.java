package com.xpf.imoney.servlet;

import com.google.gson.Gson;
import com.qiniu.util.Auth;
import com.xpf.imoney.constants.QiniuConstants;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by Vance on 2020/03/29 :)
 * Function:七牛云上传 Token
 */
@WebServlet(name = "QiniuUpTokenServlet", urlPatterns = "/QiniuUpToken")
public class QiniuUpTokenServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Auth auth = Auth.create(QiniuConstants.ACCESS_KEY, QiniuConstants.SECRET_KEY);
        String upToken = auth.uploadToken(QiniuConstants.BUCKET);
        System.out.println(upToken);

        HashMap<String,String> map = new HashMap<>();
        map.put("upToken",upToken);
        String json = new Gson().toJson(map);
        System.out.println(json);

        ServletOutputStream out = response.getOutputStream();
        out.write(json.getBytes());
        out.flush();
        out.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
