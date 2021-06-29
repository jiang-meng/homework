package com.swufe.javaee.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = "/hobbyFind")
public class HobbyServlet extends HttpServlet {
    private Map<String, String> userHobby;
    public String getList(String a){
        List<String> list = new ArrayList<>();
        list.add(a);
        return a;
    }
    @Override
    public void init() {
        userHobby = new HashMap<>();
        userHobby.put("Bob",getList("skiing"));
        userHobby.put("Jim", getList("skiing"));
        userHobby.put("James", getList("knitting"));
        userHobby.put("Tom", getList("knitting"));
        userHobby.put("Fei", getList("scuba"));
        userHobby.put("Jone", getList("scuba"));
        userHobby.put("Fred", getList("dating"));
        userHobby.put("Pradeep", getList("dating"));
        userHobby.put("Philippe", getList("dating"));
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String hobby = request.getParameter("hobby");
        List<String> names = new ArrayList<>();
        userHobby.forEach((a, b) -> {
            for (String h=b) {
                if (h.equals(hobby)){
                    names.add(a);
                }
            }
        });
        request.setAttribute("names", names);
        request.setAttribute("hobby", hobby);
        request.getRequestDispatcher("hobbyResult.jsp").forward(request, response);
    }

}