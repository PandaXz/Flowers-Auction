package com.belykh.finalProj.command.impl.common;

import com.belykh.finalProj.command.ActionCommand;
import com.belykh.finalProj.constant.PathPage;
import com.belykh.finalProj.controller.AuctionServlet;
import com.belykh.finalProj.exception.CommandException;
import com.belykh.finalProj.exception.ServiceException;
import com.belykh.finalProj.service.UserService;
import com.belykh.finalProj.util.ParameterValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignUpCommand implements ActionCommand {


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String result = null;
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String passwordRepeat = request.getParameter("passwordRepeat");
        String email = request.getParameter("email");
        String firstName = request.getParameter("fname");
        String lastName = request.getParameter("lname");

        ParameterValidator validator = ParameterValidator.getInstance();
        if(validator.validateLogin(login)&&validator.validatePassword(password)&&
                validator.validatePassword(passwordRepeat)&&validator.validateEmail(email)&&
                validator.validateName(firstName)&&validator.validateName(lastName)){
            UserService service = serviceFactory.getUserService();

            try {
                if(service.SignUp(login.trim(),password.trim(),passwordRepeat.trim(),email.trim(),firstName.trim(),lastName.trim())){
                    result= PathPage.LOGIN.getPath();
                }else{
                    request.setAttribute("errorRegistrationMessage", AuctionServlet.messageManager.getProperty("message.errorRegistration"));
                    result= PathPage.REGISTRATION.getPath();
                }
            } catch (ServiceException e) {
                throw new CommandException(e);
            }

        }
        return result;
    }
}
