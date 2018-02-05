package com.belykh.flowerAuction.command.impl.user;

import com.belykh.flowerAuction.command.ActionCommand;
import com.belykh.flowerAuction.constant.PathPage;
import com.belykh.flowerAuction.controller.AuctionServlet;
import com.belykh.flowerAuction.entity.UserInfo;
import com.belykh.flowerAuction.exception.CommandException;
import com.belykh.flowerAuction.exception.ServiceException;
import com.belykh.flowerAuction.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * The Class ChangeableInfoCommand.
 */
public class ChangeableInfoCommand implements ActionCommand {
    
    /* (non-Javadoc)
     * @see com.belykh.flowerAuction.command.ActionCommand#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String result;
        HttpSession session = request.getSession(false);
        String userLogin = (String) session.getAttribute("user");


        UserService service = serviceFactory.getUserService();
        try {
            UserInfo user = service.findUserInfo(userLogin);
            if (user==null) {
                request.setAttribute("errorLotListIsEmpty", AuctionServlet.messageManager.getProperty("message.errorUserInfoIsEmpty"));
                request.setAttribute("userInfo", null);
            } else {
                request.setAttribute("errorLotListIsEmpty", null);
                request.setAttribute("userInfo", user);
            }
            result = PathPage.CHANGE_USER_INFO.getPath();
        } catch (ServiceException e) {
            throw new CommandException(e);
        }

        return result;
    }
}
