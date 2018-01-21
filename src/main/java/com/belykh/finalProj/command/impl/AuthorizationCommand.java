package com.belykh.finalProj.command.impl;

import com.belykh.finalProj.command.ActionCommand;
import com.belykh.finalProj.controller.AuctionServlet;
import com.belykh.finalProj.entity.UserDBO;
import com.belykh.finalProj.exception.CommandException;
import com.belykh.finalProj.exception.ServiceException;
import com.belykh.finalProj.manager.ConfigurationManager;
import com.belykh.finalProj.service.ServiceFactory;
import com.belykh.finalProj.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by panda on 7.1.18.
 */
public class AuthorizationCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String result = null;
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if(login!=null&&!login.isEmpty()&&password!=null&&!password.isEmpty()){
            UserService service = ServiceFactory.getInstance().getUserService();
            try {
                UserDBO user = service.Authorization(login,password);
                if(user!=null){
                    HttpSession session = request.getSession(true);
                    if (session.getAttribute("user") == null) {
                        session.setAttribute("user", user.getLogin());
                    }
                    if (session.getAttribute("role") == null) {
                        session.setAttribute("role", user.getRole());
                    }
                    if(session.getAttribute("userId")==null){
                        session.setAttribute("userId",user.getId());
                    }

                    result= ConfigurationManager.getProperty("path.page.main");

                }else{
                    request.setAttribute("errorLoginPassMessage", AuctionServlet.messageManager.getProperty("message.errorLogin"));
                    result= ConfigurationManager.getProperty("path.page.login");
                }
            } catch (ServiceException e) {
                throw new CommandException(e);
            }
        }
        return result;
    }
}
