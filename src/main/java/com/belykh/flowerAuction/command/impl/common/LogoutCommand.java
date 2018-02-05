package com.belykh.flowerAuction.command.impl.common;

import com.belykh.flowerAuction.command.ActionCommand;
import com.belykh.flowerAuction.constant.PathPage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * The Class LogoutCommand.
 */
public class LogoutCommand implements ActionCommand {
    
    /* (non-Javadoc)
     * @see com.belykh.flowerAuction.command.ActionCommand#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        if(session!=null) {
            session.invalidate();
        }
        return PathPage.LOGIN.getPath();
    }
}
