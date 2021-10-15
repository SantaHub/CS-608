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
        String message = generateMessage(valueMap);
        displayMessage(message, response);
    }

    private void displayMessage(String message, HttpServletResponse response) throws IOException {
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
        out.println("</body></html>");
        out.println("<a href='http://localhost:8080/cs610_Project3_war_exploded'/>");
    }

    private  String generateMessage(Map<String, String> valueMap){
        Boolean isNameGood = validateValue(valueMap, "name");
        Boolean isAgeGood = validateValue(valueMap, "age");
        String name = null,age = null;

        if(!isNameGood && !isAgeGood){
            return  "Must enter a name and Age. ";
        }
        if(isNameGood && !isAgeGood){
            return "Must enter a Age.";
        }
        if(!isNameGood && isAgeGood){
            return "Must enter a name.";
        }

        if(isNameGood && isAgeGood){
            name = valueMap.get("name");
            age = valueMap.get("age");
            if(!isValueInteger(age)){
                return "Age must be a positive integer in the range of 1 to 100.";
            }
            if(isValueNegative(age)){
                return "Age cannot be negative";
            }
            if(!validateValueRange(age, 1, 100)){
                return "Age must be a positive integer in the range of 1 to 100.";
            }

        }
        return  name +", you are "+ age+" years old.";
    }

    private Boolean isValueNegative(String age) {
        Boolean isNegative = false;
        int value = Integer.valueOf(age);
        if (value < 0) {
            isNegative = true;
        }
        return isNegative;
    }

    private Boolean isValueInteger(String ageString){
        Boolean isValueInt = true;
        try {
            Integer.parseInt(ageString);
        } catch (NumberFormatException exception){
            isValueInt = false;
        }
        return isValueInt;
    }


    private Boolean validateValueRange(String valueString, int start, int end) {
        Boolean isRangeGood = false;
        int value = Integer.valueOf(valueString);
        if(value >= start  && value <= end){
            isRangeGood = true;
        }
        return isRangeGood;
    }

    private Boolean validateValue(Map<String, String> valueMap, String key ){
        Boolean isValuePresent = false;
        if(valueMap.containsKey(key) & valueMap.get(key) != null) {
            isValuePresent = true;
        }
        return isValuePresent;
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