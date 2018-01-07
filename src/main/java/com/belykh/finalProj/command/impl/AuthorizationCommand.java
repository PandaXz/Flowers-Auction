package com.belykh.finalProj.command.impl;

import com.belykh.finalProj.command.ActionCommand;
import com.belykh.finalProj.exception.CommandException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by panda on 7.1.18.
 */
public class AuthorizationCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if(login!=null&&!login.isEmpty()&&password!=null&&!password.isEmpty()){

        }
        return null;
    }
}
