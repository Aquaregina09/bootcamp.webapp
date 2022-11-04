package com.bootcamp.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bootcamp.demo.bean.RegistrationFormBean;

@WebServlet(urlPatterns = "/success", loadOnStartup = 2)
public class RegistrationSuccessServlet extends BaseHttpServlet {
    private static final long serialVersionUID = 3094628009000978694L;
    private static final Logger LOGGER = LogManager.getLogger(RegistrationSuccessServlet.class);

    @Override
    protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final RegistrationFormBean registrationFormBean = (RegistrationFormBean)request.getAttribute("registrationFormBean");
        LOGGER.info("action=register, status=success, registration_form_bean={}", registrationFormBean);

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.print("Welcome " + registrationFormBean.getFirstName() + " " + registrationFormBean.getLastName());
        out.flush();
        out.close();
    }
}
