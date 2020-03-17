package com.imooc.controller;

import com.imooc.controller.frontend.MainPageController;
import com.imooc.controller.superadmin.HeadLineOperationController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 模拟SpringMVC请求转发
 */
@WebServlet("/")
public class DispatcherServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String servletPath = req.getServletPath();
        String method = req.getMethod();
        System.out.println(servletPath);
        System.out.println(method);

        if(servletPath.equals("/frontend/getmainpageinfo") && method.equals("GET")) {
            MainPageController mainPageController = new MainPageController();
            mainPageController.getMainPageInfo(req, resp);
        } else if (servletPath.equals("/superadmin/addheadline") && method.equals("GET")) {
            HeadLineOperationController headLineOperationController = new HeadLineOperationController();
            headLineOperationController.addHeadLine(req, resp);
        }

    }
}
