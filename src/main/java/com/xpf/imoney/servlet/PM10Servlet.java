package com.xpf.imoney.servlet;

import com.xpf.imoney.constants.MapKeys;
import com.xpf.imoney.utils.ParseParamUtils;
import com.xpf.imoney.utils.VerifyUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

/**
 * Created by Vance on 2019/07/24 :)
 * Function:
 */
@WebServlet(name = "PM10Servlet", urlPatterns = "/pm10")
public class PM10Servlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String queryString = request.getQueryString();
        Map<String, String> requestParam = ParseParamUtils.getRequestParam(queryString);
        String city = requestParam.get(MapKeys.CITY);
        String token = requestParam.get(MapKeys.TOKEN);
        System.out.println("city:" + city + ",token:" + token);

        response.setContentType("utf-8");
        response.setCharacterEncoding("utf-8");
        OutputStream os = response.getOutputStream();

        String path = getServletContext().getRealPath("/") + VerifyUtils.getPathByToken(token,"json/pm10.json");
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
