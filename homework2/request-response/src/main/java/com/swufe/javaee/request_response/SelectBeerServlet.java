package com.swufe.javaee.request_response;

import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SelectBeerServlet", value = "/SelectBeerServlet")
public class SelectBeerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String body = request.getParameter("body");

        String number = request.getParameter("amount");
        if (number.length() == 0){
            response.sendRedirect("erro.html");
            return;
        }
        int amount;
        try{
            amount = Integer.parseInt(request.getParameter("amount")) + 2;
        }catch (NumberFormatException e){
            response.sendRedirect("erro2.html");
            return;
        }

        String[] sizes = request.getParameterValues("sizes");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>This is get response</h1>");
        out.println("<p>body: " + body + "</p>");
        out.println("<p>amount: " + amount + "</p>");
        for (String s : sizes) {
            out.println("<p>sizes: " + s + "</p>");
        }
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String body = request.getParameter("body");
        String number = request.getParameter("amount");
        if (number.length() == 0){
            response.sendRedirect("erro.html");
            return;
        }
        int amount;
        try{
            amount = Integer.parseInt(request.getParameter("amount")) + 2;
        }catch (NumberFormatException e){
            response.sendRedirect("erro2.html");
            return;
        }
        String[] sizes = request.getParameterValues("sizes");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>This is post response</h1>");
        out.println("<p>body: " + body + "</p>");
        out.println("<p>amount: " + amount + "</p>");
        for (String s : sizes) {
            out.println("<p>sizes: " + s + "</p>");
        }
        out.println("</body></html>");
    }
}
