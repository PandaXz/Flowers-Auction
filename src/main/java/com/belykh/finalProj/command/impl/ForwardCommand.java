package com.belykh.finalProj.command.impl;

import com.belykh.finalProj.command.ActionCommand;
import com.belykh.finalProj.exception.CommandException;
import com.belykh.finalProj.manager.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by panda on 7.12.17.
 */
public class ForwardCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String page = request.getParameter("page");
        String requestPage = null;
        if (page != null) {
            switch (page) {
                case "offer_lot.title":{
                    requestPage = ConfigurationManager.getProperty("path.page.offer_lot");
                    break;
                }
                case "change_password":{
                    requestPage = ConfigurationManager.getProperty("path.page.change_password");
                    break;
                }
                case "login":{
                    requestPage = ConfigurationManager.getProperty("path.page.login");
                    break;
                }
                case "registration": {
                    requestPage = ConfigurationManager.getProperty("path.page.registration");
                    break;
                }
                default: {
                    requestPage = ConfigurationManager.getProperty("path.page.index");
                }
            }
        } else {
            requestPage = ConfigurationManager.getProperty("path.page.index");
        }
        return requestPage;
    }
}
