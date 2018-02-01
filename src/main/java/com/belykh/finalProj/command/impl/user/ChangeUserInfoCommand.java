package com.belykh.finalProj.command.impl.user;

import com.belykh.finalProj.command.ActionCommand;
import com.belykh.finalProj.constant.PathPage;
import com.belykh.finalProj.controller.AuctionServlet;
import com.belykh.finalProj.exception.CommandException;
import com.belykh.finalProj.exception.ServiceException;
import com.belykh.finalProj.service.ServiceFactory;
import com.belykh.finalProj.service.UserService;
import com.belykh.finalProj.util.ParameterValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ChangeUserInfoCommand implements ActionCommand{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        HttpSession session = request.getSession(false);
        String login = (String) session.getAttribute("user");
        String email = request.getParameter("email");
        String firstName = request.getParameter("fname");
        String lastName = request.getParameter("lname");
        ParameterValidator validator = ParameterValidator.getInstance();
        if(validator.validateEmail(email)&&
                validator.validateName(firstName)&&validator.validateName(lastName)){
            UserService service = ServiceFactory.getInstance().getUserService();

            try {
                if(service.changeUserInfo(login,email.trim(),firstName.trim(),lastName.trim())){

                }else{
                    request.setAttribute("errorChangeMessage", AuctionServlet.messageManager.getProperty("message.errorChangeUserInfo"));
                }
            } catch (ServiceException e) {
                throw new CommandException(e);
            }

        }
        return PathPage.CHANGE_USER_INFO.getPath();
    }
}
