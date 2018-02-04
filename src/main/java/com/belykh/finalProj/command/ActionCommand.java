package com.belykh.finalProj.command;

import com.belykh.finalProj.exception.CommandException;
import com.belykh.finalProj.service.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by panda on 16.11.17.
 */
public interface ActionCommand {
    ServiceFactory serviceFactory = new ServiceFactory();
    String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException;
}
