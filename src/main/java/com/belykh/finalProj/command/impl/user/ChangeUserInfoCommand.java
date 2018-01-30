package com.belykh.finalProj.command.impl.user;

import com.belykh.finalProj.command.ActionCommand;
import com.belykh.finalProj.controller.AuctionServlet;
import com.belykh.finalProj.exception.CommandException;
import com.belykh.finalProj.exception.ServiceException;
import com.belykh.finalProj.manager.ConfigurationManager;
import com.belykh.finalProj.service.ServiceFactory;
import com.belykh.finalProj.service.UserService;
import com.belykh.finalProj.util.ParameterValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ChangeUserInfoCommand implements ActionCommand{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String result = null;
        HttpSession session = request.getSession(false);
        String login = (String) session.getAttribute("user");
        String email = request.getParameter("email").trim();
        String firstName = request.getParameter("fname").trim();
        String lastName = request.getParameter("lname").trim();

        if(ParameterValidator.getInstance().validateEmail(email)){
            UserService service = ServiceFactory.getInstance().getUserService();

            try {
                if(service.changeUserInfo(login,email.trim(),firstName.trim(),lastName.trim())){
                    result= ConfigurationManager.getProperty("path.page.user_info");
                }else{
                    request.setAttribute("errorChangeMessage", AuctionServlet.messageManager.getProperty("message.errorChangeUserInfo"));
                    result= ConfigurationManager.getProperty("path.page.change_user_info");
                }
            } catch (ServiceException e) {
                throw new CommandException(e);
            }

        }
        return result;
    }
}
