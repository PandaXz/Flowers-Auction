package com.belykh.finalProj.command.impl.common;

import com.belykh.finalProj.command.ActionCommand;
import com.belykh.finalProj.constant.PathPage;
import com.belykh.finalProj.exception.CommandException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// TODO: Auto-generated Javadoc
/**
 * The Class ForwardCommand.
 */
public class ForwardCommand implements ActionCommand {
    
    /* (non-Javadoc)
     * @see com.belykh.finalProj.command.ActionCommand#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
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
