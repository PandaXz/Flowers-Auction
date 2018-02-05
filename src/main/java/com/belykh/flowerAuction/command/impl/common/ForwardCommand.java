package com.belykh.flowerAuction.command.impl.common;

import com.belykh.flowerAuction.command.ActionCommand;
import com.belykh.flowerAuction.constant.PathPage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The Class ForwardCommand.
 */
public class ForwardCommand implements ActionCommand {
    
    /* (non-Javadoc)
     * @see com.belykh.flowerAuction.command.ActionCommand#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = request.getParameter("page");
        String requestPage = PathPage.MAIN.getPath();
        if (page != null) {
            switch (page) {
                case "login":{
                    requestPage = PathPage.LOGIN.getPath();
                    break;
                }
                case "registration": {
                    requestPage = PathPage.REGISTRATION.getPath();
                    break;
                }
            }
        }
        return requestPage;
    }
}
