package com.xpf.imoney.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "P2PInvestServlet", urlPatterns = "/invest")
public class P2PInvestServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // response.setContentType("text/html");
        // PrintWriter out = response.getWriter();
        // out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        // out.println("<HTML>");
        // out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
        // out.println("  <BODY>");
        // out.print("    This is ");
        // out.print(this.getClass());
        // out.println(", using the GET method");
        // out.println("  </BODY>");
        // out.println("</HTML>");
        // out.flush();
        // out.close();
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        //流输出信息
        PrintWriter out = response.getWriter();

        // 浏览器显示信息
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<HTML>");
        out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
        out.println("  <BODY>");
        out.print("你请求的module名称是:");

        String module = request.getParameter("module");
        // 根据模块名称，设置请求的返回结果
        if (module != null && !"".equals(module)) {
            int tempM = Integer.parseInt(module);
            switch (tempM) {
                case 0:
                    // 首页
                    out.println(" 首页");
                    break;
                case 1:
                    // 我要投资
                    out.println(" 我要投资");
                    break;
                case 2:
                    // 我的资产
                    out.println(" 我的资产");
                    break;
            }
        } else {
            out.println(" 你没有指定module参数");
        }
        out.println("  </BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
    }

}
