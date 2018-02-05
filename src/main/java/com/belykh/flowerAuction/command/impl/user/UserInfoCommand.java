package com.belykh.flowerAuction.command.impl.user;

import com.belykh.flowerAuction.command.ActionCommand;
import com.belykh.flowerAuction.constant.PathPage;
import com.belykh.flowerAuction.controller.AuctionServlet;
import com.belykh.flowerAuction.entity.UserInfo;
import com.belykh.flowerAuction.exception.CommandException;
import com.belykh.flowerAuction.exception.ServiceException;
import com.belykh.flowerAuction.service.UserService;
import com.belykh.flowerAuction.util.ParameterValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * The Class UserInfoCommand.
 */
public class UserInfoCommand implements ActionCommand {
    
    /* (non-Javadoc)
     * @see com.belykh.flowerAuction.command.ActionCommand#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String result;
        String userIdString = request.getParameter("id");
        Long userId;
        if (!ParameterValidator.getInstance().validateId(userIdString)) {
            HttpSession session = request.getSession(false);
            userId = (Long) session.getAttribute("userId");

        }else{
            userId=Long.decode(userIdString);
        }
        UserService service = serviceFactory.getUserService();
        try {
            UserInfo user = service.findUserInfoById(userId);
            if (user==null) {
                request.setAttribute("userInfo", null);
                request.setAttribute("errorLotListIsEmpty", AuctionServlet.messageManager.getProperty("message.errorUserInfoIsEmpty"));
            } else {
                request.setAttribute("errorLotListIsEmpty", null);
                request.setAttribute("userInfo", user);
            }
            result = PathPage.USER_INFORMATION.getPath();
        } catch (ServiceException e) {
            throw new CommandException(e);
        }

        return result;
    }
}
