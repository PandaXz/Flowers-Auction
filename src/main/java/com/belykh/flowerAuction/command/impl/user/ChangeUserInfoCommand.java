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
 * The Class ChangeUserInfoCommand.
 */
public class ChangeUserInfoCommand implements ActionCommand{

    /* (non-Javadoc)
     * @see com.belykh.flowerAuction.command.ActionCommand#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
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
            UserService service = serviceFactory.getUserService();

            try {
                if(!service.changeUserInfo(login,email.trim(),firstName.trim(),lastName.trim())){
                    request.setAttribute("errorChangeMessage", AuctionServlet.messageManager.getProperty("message.errorChangeUserInfo"));
                }
            } catch (ServiceException e) {
                throw new CommandException(e);
            }

        }
        return PathPage.CHANGE_USER_INFO.getPath();
    }
}
