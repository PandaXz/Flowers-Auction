package com.belykh.finalProj.command.impl;

import com.belykh.finalProj.command.ActionCommand;
import com.belykh.finalProj.controller.AuctionServlet;
import com.belykh.finalProj.exception.CommandException;
import com.belykh.finalProj.exception.ServiceException;
import com.belykh.finalProj.manager.ConfigurationManager;
import com.belykh.finalProj.service.ServiceFactory;
import com.belykh.finalProj.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignUpCommand implements ActionCommand {


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String result = null;
        String login = request.getParameter("login").trim();
        String password = request.getParameter("password").trim();
        String passwordRepeat = request.getParameter("passwordRepeat").trim();
        String email = request.getParameter("email").trim();
        String firstName = request.getParameter("fname").trim();
        String lastName = request.getParameter("lname").trim();

        if(login!=null&&!login.isEmpty()&&password!=null&&!password.isEmpty()&&
                passwordRepeat!=null&&!passwordRepeat.isEmpty()&&email!=null&&!email.isEmpty()){
            UserService service = ServiceFactory.getInstance().getUserService();

            try {
                if(service.SignUp(login,password,passwordRepeat,email,firstName,lastName)){
                    result= ConfigurationManager.getProperty("path.page.login");
                }else{
                    request.setAttribute("errorRegistrationMessage", AuctionServlet.messageManager.getProperty("message.errorRegistration"));
                    result= ConfigurationManager.getProperty("path.page.registration");
                }
            } catch (ServiceException e) {
                throw new CommandException(e);
            }

        }
        return result;
    }
}
