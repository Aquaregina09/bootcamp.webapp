package com.bootcamp.demo.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bootcamp.demo.bean.RegistrationFormBean;

@WebServlet(urlPatterns = "/register", loadOnStartup = 1)
public class RegistrationServlet extends BaseHttpServlet {

    private static final long serialVersionUID = -9174495987589377144L;
    private static final Logger LOGGER = LogManager.getLogger(RegistrationServlet.class);

    @Override
    protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final RegistrationFormBean registrationFormBean = toRegistrationFormBean(request);
        request.setAttribute("registrationFormBean", registrationFormBean);
        LOGGER.info("action=register, registration_form_bean={}", registrationFormBean);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/success");
        dispatcher.forward(request, response);
    }

    private RegistrationFormBean toRegistrationFormBean(HttpServletRequest request) {
        RegistrationFormBean registrationFormBean = new RegistrationFormBean();
        registrationFormBean.setFirstName(request.getParameter("firstName"));
        registrationFormBean.setLastName(request.getParameter("lastName"));
        registrationFormBean.setEmail(request.getParameter("email"));
        registrationFormBean.setPassword(request.getParameter("password"));
        registrationFormBean.setConfirmPassword(request.getParameter("confirmPassword"));
        return registrationFormBean;
    }

}
