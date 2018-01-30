package com.belykh.finalProj.command.impl.user;

import com.belykh.finalProj.command.ActionCommand;
import com.belykh.finalProj.controller.AuctionServlet;
import com.belykh.finalProj.entity.UserInfo;
import com.belykh.finalProj.exception.CommandException;
import com.belykh.finalProj.exception.ServiceException;
import com.belykh.finalProj.manager.ConfigurationManager;
import com.belykh.finalProj.service.ServiceFactory;
import com.belykh.finalProj.service.UserService;
import com.belykh.finalProj.util.ParameterValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserInfoCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String result = null;
        String userLogin = request.getParameter("user");

        if (!ParameterValidator.getInstance().validateLogin(userLogin)) {
            HttpSession session = request.getSession(false);
            userLogin = (String) session.getAttribute("user");

        }
        UserService service = ServiceFactory.getInstance().getUserService();
        try {
            UserInfo user = service.findUserInfo(userLogin);
            if (user==null) {
                request.setAttribute("userInfo", null);
                request.setAttribute("errorLotListIsEmpty", AuctionServlet.messageManager.getProperty("message.errorUserInfoIsEmpty"));
            } else {
                request.setAttribute("errorLotListIsEmpty", null);
                request.setAttribute("userInfo", user);
            }
            result = ConfigurationManager.getProperty("path.page.user_info");
        } catch (ServiceException e) {
            throw new CommandException(e);
        }

        return result;
    }
}
