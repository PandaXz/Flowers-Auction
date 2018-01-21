package com.belykh.finalProj.command;

import com.belykh.finalProj.manager.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by panda on 16.11.17.
 */
public class EmptyCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        return ConfigurationManager.getProperty("path.page.index");
    }
}
