package com.belykh.finalProj.command.impl;

import com.belykh.finalProj.command.ActionCommand;
import com.belykh.finalProj.manager.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by panda on 16.11.17.
 */
public class LogoutCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        if(session!=null) {
            session.invalidate();
        }
        return ConfigurationManager.getProperty("path.page.login");
    }
}
