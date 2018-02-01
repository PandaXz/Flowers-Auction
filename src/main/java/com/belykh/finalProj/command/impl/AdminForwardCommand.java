package com.belykh.finalProj.command.impl;

import com.belykh.finalProj.command.ActionCommand;
import com.belykh.finalProj.constant.PathPage;
import com.belykh.finalProj.exception.CommandException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by panda on 9.12.17.
 */
public class AdminForwardCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String page = request.getParameter("page");
        String requestPage = PathPage.MAIN.getPath();
        if (page != null) {
            switch (page) {

            }
        }
        return requestPage;
    }
}
