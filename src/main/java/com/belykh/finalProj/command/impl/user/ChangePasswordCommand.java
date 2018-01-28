package com.belykh.finalProj.command.impl.user;

import com.belykh.finalProj.command.ActionCommand;
import com.belykh.finalProj.controller.AuctionServlet;
import com.belykh.finalProj.exception.CommandException;
import com.belykh.finalProj.exception.ServiceException;
import com.belykh.finalProj.manager.ConfigurationManager;
import com.belykh.finalProj.service.ServiceFactory;
import com.belykh.finalProj.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ChangePasswordCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String result = null;
        HttpSession session = request.getSession(false);
        String login = (String) session.getAttribute("user");
        String password = request.getParameter("password");
        String passwordRepeat = request.getParameter("passwordRepeat");

        if(login!=null&&!login.isEmpty()&&password!=null&&!password.isEmpty()&&
                passwordRepeat!=null&&!passwordRepeat.isEmpty()){
            UserService service = ServiceFactory.getInstance().getUserService();

            try {
                if(service.changePassword(login,password,passwordRepeat)){
                    result= ConfigurationManager.getProperty("path.page.change_password");
                    request.setAttribute("successChangeMessage", AuctionServlet.messageManager.getProperty("message.successChangePassword"));

                }else{
                    request.setAttribute("errorChangeMessage", AuctionServlet.messageManager.getProperty("message.errorChangePassword"));
                    result= ConfigurationManager.getProperty("path.page.change_password");
                }
            } catch (ServiceException e) {
                throw new CommandException(e);
            }

        }
        return result;
    }
}
