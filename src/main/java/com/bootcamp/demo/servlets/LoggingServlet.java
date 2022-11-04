package com.bootcamp.demo.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingServlet extends HttpServlet {

    private static final long serialVersionUID = 11985107571187021L;

    private static final Logger LOGGER = LogManager.getLogger(LoggingServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String paymentMethod = request.getParameter("paymentMethod");
        final String status = request.getParameter("status");
        LOGGER.info("action=process_payment, payment_method={}, status={}", paymentMethod, status);
    }

}
