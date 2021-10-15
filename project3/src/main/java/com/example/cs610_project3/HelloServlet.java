package com.example.cs610_project3;

import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "nameAge", value = "/name-age")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Test!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println(request);
        response.setContentType("text/html");

        Enumeration<String> names = request.getParameterNames();
        while
        (names.hasMoreElements() ){
            String name = (String)names.nextElement();
            String value = request.getParameter(name);
            System.out.println("("+ name +", "+ value +")");
        }

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String, String> valueMap = generateMap(request);

    }

    private Map<String, String> generateMap(HttpServletRequest request){
        Map<String, String> valueMap =  new HashMap<>();

        Enumeration<String> names = request.getParameterNames();
        while
        (names.hasMoreElements() ){
            String name = (String)names.nextElement();
            String value = request.getParameter(name);
            valueMap.put(name, value);
        }
        return valueMap;
    }

    public void destroy() {
    }
}