package com.nexse.swat.tutorial.mvn.web;

import com.nexse.swat.tutorial.mvn.GuavaHashService;
import com.nexse.swat.tutorial.mvn.HashService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HashingServlet extends javax.servlet.http.HttpServlet {

    private final HashService hashService = new GuavaHashService();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Content-Type", "text/html");
        final PrintWriter writer = response.getWriter();

        final String input = request.getParameter("input");
        if (input != null && !input.isEmpty()) {
            writer.print("<p>The md5 hash for the input string <strong>");
            writer.print(input);
            writer.print("</strong> is <strong>");
            writer.print(hashService.md5(input));
            writer.println("</strong></p>");
        }

        writer.println("<p><form method=\"post\">");
        writer.println("input: <input type=\"text\" name=\"input\"/>");
        writer.println("<input type=\"submit\"/>");
        writer.println("</form></p>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        service(request, response);
    }

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws ServletException, IOException {
        service(request, response);
    }

}
