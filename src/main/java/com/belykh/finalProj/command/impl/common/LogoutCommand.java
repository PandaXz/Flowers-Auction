package com.belykh.finalProj.command.impl.common;

import com.belykh.finalProj.command.ActionCommand;
import com.belykh.finalProj.constant.PathPage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// TODO: Auto-generated Javadoc
/**
 * The Class LogoutCommand.
 */
public class LogoutCommand implements ActionCommand {
    
    /* (non-Javadoc)
     * @see com.belykh.finalProj.command.ActionCommand#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
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
