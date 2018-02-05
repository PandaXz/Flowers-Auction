package com.belykh.flowerAuction.command.impl.admin;

import com.belykh.flowerAuction.command.ActionCommand;
import com.belykh.flowerAuction.constant.PathPage;
import com.belykh.flowerAuction.controller.AuctionServlet;
import com.belykh.flowerAuction.entity.UserInfo;
import com.belykh.flowerAuction.exception.CommandException;
import com.belykh.flowerAuction.exception.ServiceException;
import com.belykh.flowerAuction.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * The Class UserListCommand.
 */
public class UserListCommand implements ActionCommand {
    
    /* (non-Javadoc)
     * @see com.belykh.flowerAuction.command.ActionCommand#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String result;

        UserService service = serviceFactory.getUserService();
        try {
            List<UserInfo> userList=service.findUsersInfo();
            if (userList.isEmpty()) {
                request.setAttribute("userList", null);
                request.setAttribute("errorUserListIsEmpty", AuctionServlet.messageManager.getProperty("message.errorUserListIsEmpty"));
            } else {
                request.setAttribute("errorUserListIsEmpty", null);
                request.setAttribute("userList", userList);
            }
            result = PathPage.USER_LIST.getPath();
        } catch (ServiceException e) {
            throw new CommandException(e);
        }

        return result;
    }
}
