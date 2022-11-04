package com.bootcamp.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ServletB extends HttpServlet {

    private static final long serialVersionUID = 4835150738055117383L;

    private static final Logger LOGGER = LogManager.getLogger(ServletB.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final ServletContext context = getServletContext();
        final String name = (String)context.getAttribute("name");
        final String greeting = "Hello " + (name != null ? name : "Guest");
        
        final String email = (String) request.getAttribute("email");

        PrintWriter out = response.getWriter();
        out.println(String.format("<h1>%s</h1>", greeting));
        out.println(String.format("<h1>%s</h1>", email));
        out.flush();
        out.close();

        LOGGER.info("action=do_get, source=servlet_b");
    }

}
