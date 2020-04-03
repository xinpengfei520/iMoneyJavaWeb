package com.xpf.imoney.servlet;

import com.google.gson.Gson;
import com.qiniu.util.Auth;
import com.qiniu.util.IOUtils;
import com.xpf.imoney.bean.request.QiniuRequestBean;
import org.apache.http.util.TextUtils;

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
        byte[] bytes = IOUtils.toByteArray(request.getInputStream());
        String requestBody = new String(bytes);

        QiniuRequestBean qiniuRequestBean = new Gson().fromJson(requestBody, QiniuRequestBean.class);
        String accessKey = qiniuRequestBean.getAccessKey();
        String secretKey = qiniuRequestBean.getSecretKey();
        String bucket = qiniuRequestBean.getBucket();

        System.out.println("accessKey:" + accessKey + ",secretKey:" + secretKey + ",bucket:" + bucket);

        HashMap<String, String> map = new HashMap<>();
        if (!TextUtils.isEmpty(accessKey) && !TextUtils.isEmpty(secretKey) && !TextUtils.isEmpty(bucket)) {
            Auth auth = Auth.create(accessKey, secretKey);
            String upToken = auth.uploadToken(bucket);
            System.out.println("upToken:" + upToken);
            map.put("upToken", upToken);
        } else {
            map.put("errorMsg", "accessKey、secretKey、bucket都不能为空！");
        }

        String responseBody = new Gson().toJson(map);
        System.out.println("responseBody:" + responseBody);

        ServletOutputStream out = response.getOutputStream();
        out.write(responseBody.getBytes());
        out.flush();
        out.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
