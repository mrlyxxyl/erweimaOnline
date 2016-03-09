package com.yuexin.servlet;

import com.yuexin.util.TwoDimensionCode;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-9
 * Time: 上午10:13
 * To change this template use File | Settings | File Templates.
 */
public class ImageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String encoderContent = request.getParameter("txt");
        String rootPath = request.getServletContext().getRealPath("/images");
        File file = new File(rootPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        String imageName = System.currentTimeMillis() + ".png";
        String imgPath = rootPath + "/" + imageName;
        TwoDimensionCode handler = new TwoDimensionCode();
        handler.encoderQRCode(encoderContent, imgPath, "png");
        response.getOutputStream().print("images/" + imageName);
    }
}
