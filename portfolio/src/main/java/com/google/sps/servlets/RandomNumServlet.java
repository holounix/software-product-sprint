package com.google.sps.servlets;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Handles requests sent to the /hello URL. Try running a server and navigating to /hello! */
@WebServlet("/randomNum")
public class RandomNumServlet extends HttpServlet { 

    ArrayList<String> numArray = new ArrayList<String>(Arrays.asList("1","2","3","4","5","6","7","8"));

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String json = convertToJsonUsingGson(numArray);
        response.setContentType("application/json;");
        response.getWriter().println(json);
    }

    public String convertToJsonUsingGson(ArrayList<String> numArray) {
        Gson gson = new Gson();
        String json = gson.toJson(numArray);
        return json;
    }
}