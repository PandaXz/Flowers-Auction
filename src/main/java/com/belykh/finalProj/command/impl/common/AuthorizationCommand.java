package com.belykh.finalProj.command.impl.common;

import com.belykh.finalProj.command.ActionCommand;
import com.belykh.finalProj.constant.PathPage;
import com.belykh.finalProj.controller.AuctionServlet;
import com.belykh.finalProj.entity.dbo.UserDBO;
import com.belykh.finalProj.exception.CommandException;
import com.belykh.finalProj.exception.ServiceException;
import com.belykh.finalProj.service.UserService;
import com.belykh.finalProj.util.ParameterValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// TODO: Auto-generated Javadoc
/**
 * The Class AuthorizationCommand.
 */
public class AuthorizationCommand implements ActionCommand {
    
    /* (non-Javadoc)
     * @see com.belykh.finalProj.command.ActionCommand#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String result = null;
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        ParameterValidator validator = ParameterValidator.getInstance();
        if(validator.validateLogin(login)&&validator.validatePassword(password)){
            UserService service = serviceFactory.getUserService();
            try {
                UserDBO user = service.Authorization(login.trim(),password.trim());
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
                    if(user.getRole()==2&& session.getAttribute("isAdmin")==null){
                        session.setAttribute("isAdmin",true);
                    }

                    result= PathPage.MAIN.getPath();

                }else{
                    request.setAttribute("errorLoginPassMessage", AuctionServlet.messageManager.getProperty("message.errorLogin"));
                    result= PathPage.LOGIN.getPath();
                }
            } catch (ServiceException e) {
                throw new CommandException(e);
            }
        }
        return result;
    }
}
