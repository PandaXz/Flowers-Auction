package com.belykh.flowerAuction.command.impl.common;

import com.belykh.flowerAuction.command.ActionCommand;
import com.belykh.flowerAuction.constant.PathPage;
import com.belykh.flowerAuction.controller.AuctionServlet;
import com.belykh.flowerAuction.exception.CommandException;
import com.belykh.flowerAuction.exception.ServiceException;
import com.belykh.flowerAuction.service.UserService;
import com.belykh.flowerAuction.util.ParameterValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The Class SignUpCommand.
 */
public class SignUpCommand implements ActionCommand {


    /* (non-Javadoc)
     * @see com.belykh.flowerAuction.command.ActionCommand#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
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
