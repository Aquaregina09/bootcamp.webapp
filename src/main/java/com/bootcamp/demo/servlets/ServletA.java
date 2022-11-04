package com.bootcamp.demo.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/** 
 * Scopes 
 * 
 * application context => ServletContext 
 * request => HttpServletRequest
 * session => HttpSession 
 * page (JSP) => PageContext 
 * 
 * setAttribute(String, Object)
 * getAttribute(String): Object 
 * removeAttribute(String)
 */
public class ServletA extends HttpServlet {

    private static final long serialVersionUID = 4835150738055117383L;

    private static final Logger LOGGER = LogManager.getLogger(ServletA.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("action=do_get, source=servlet_a");

        final ServletContext context = getServletContext();
        context.setAttribute("name", "John Doe");

        request.setAttribute("email", "john.doe@gmail.com");

        //response.sendRedirect("./b");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/b");
        dispatcher.forward(request, response);
    }

}
