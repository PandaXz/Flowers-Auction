package com.belykh.flowerAuction.command.impl.common;

import com.belykh.flowerAuction.command.ActionCommand;
import com.belykh.flowerAuction.constant.PathPage;
import com.belykh.flowerAuction.controller.AuctionServlet;
import com.belykh.flowerAuction.entity.dto.UserDTO;
import com.belykh.flowerAuction.exception.CommandException;
import com.belykh.flowerAuction.exception.ServiceException;
import com.belykh.flowerAuction.service.UserService;
import com.belykh.flowerAuction.util.ParameterValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * The Class AuthorizationCommand.
 */
public class AuthorizationCommand implements ActionCommand {
    
    /* (non-Javadoc)
     * @see com.belykh.flowerAuction.command.ActionCommand#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
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
                UserDTO user = service.Authorization(login.trim(),password.trim());
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
