package com.swufe.javaee.session;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");//使客户端浏览器，区分不同种类的数据，并根据不同的MIME调用浏览器内不同的程序嵌入模块来处理相应的数据。
        PrintWriter out = response.getWriter();//PrintWriter可以直接调用write()或print()方法，把字符串作为参数写入
        out.println("<html><body>");
        HttpSession session = request.getSession();
        if (session.isNew()) {
            out.println("<h1> This is a new session. </h1>");
        } else {
            out.println("<h1> Welcome back. </h1>");
        }
        out.println("</body></html>");
    }
}