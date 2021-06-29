package com.swufe.javaee.session;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

@WebServlet(name = "SignInServlet", value = "/sign-in")
public class SignInServlet extends HttpServlet {
    private Map<String, String> m;

    @Override
    public void init() throws ServletException {
        try (Stream<String> lines = Files.lines(Paths.get("fd"))) {

        } catch (IOException e) {

        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("sign-in.html").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("inputName");
        String password = req.getParameter("inputPassword");

        Stream<String> lines = Files.lines(Paths.get("C:\\Users\\姜萌\\Desktop\\password.txt.txt"));
        HashMap<String, String> a = new HashMap<>();
        lines.forEach(line -> {
            String[] name_pwd = line.split(" ");
            a.put(name_pwd[0], name_pwd[1]);
        });     //read the file

        if (!a.containsKey(name)) {
            req.getRequestDispatcher("error.jsp").forward(req, resp);
            //  if no such user, redirect to error page
        } else {
            if (a.get(name).equals(password)) {
                req.getSession().setAttribute("user", name);
                resp.sendRedirect("home.jsp");
            } else {
                req.getRequestDispatcher("error.jsp").forward(req, resp);
                // if the password.txt is wrong, then redirect to error page


            }
        }

    }
}
