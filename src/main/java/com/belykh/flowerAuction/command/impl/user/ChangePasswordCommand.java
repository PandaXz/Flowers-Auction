package com.belykh.flowerAuction.command.impl.user;

import com.belykh.flowerAuction.command.ActionCommand;
import com.belykh.flowerAuction.constant.PathPage;
import com.belykh.flowerAuction.controller.AuctionServlet;
import com.belykh.flowerAuction.exception.CommandException;
import com.belykh.flowerAuction.exception.ServiceException;
import com.belykh.flowerAuction.service.UserService;
import com.belykh.flowerAuction.util.ParameterValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * The Class ChangePasswordCommand.
 */
public class ChangePasswordCommand implements ActionCommand {
    
    /* (non-Javadoc)
     * @see com.belykh.flowerAuction.command.ActionCommand#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        HttpSession session = request.getSession(false);
        String login = (String) session.getAttribute("user");
        String password = request.getParameter("password");
        String passwordRepeat = request.getParameter("passwordRepeat");

        ParameterValidator validator = ParameterValidator.getInstance();
        if(validator.validatePassword(password)&& validator.validatePassword(passwordRepeat)){
            UserService service = serviceFactory.getUserService();

            try {
                if(service.changePassword(login,password.trim(),passwordRepeat.trim())){

                    request.setAttribute("successChangeMessage", AuctionServlet.messageManager.getProperty("message.successChangePassword"));

                }else{
                    request.setAttribute("errorChangeMessage", AuctionServlet.messageManager.getProperty("message.errorChangePassword"));
                }
            } catch (ServiceException e) {
                throw new CommandException(e);
            }

        }
        return PathPage.CHANGE_PASSWORD.getPath();
    }
}
