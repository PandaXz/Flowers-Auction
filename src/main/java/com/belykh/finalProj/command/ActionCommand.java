package com.belykh.finalProj.command;

import com.belykh.finalProj.exception.CommandException;
import com.belykh.finalProj.service.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// TODO: Auto-generated Javadoc
/**
 * The Interface ActionCommand.
 */
public interface ActionCommand {
    
    /** The service factory. */
    ServiceFactory serviceFactory = new ServiceFactory();
    
    /**
     * Execute.
     *
     * @param request the request
     * @param response the response
     * @return the string
     * @throws CommandException the command exception
     */
    String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException;
}
