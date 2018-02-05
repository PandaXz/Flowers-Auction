package com.belykh.flowerAuction.command;

import com.belykh.flowerAuction.exception.CommandException;
import com.belykh.flowerAuction.service.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The Interface ActionCommand for Command pattern.
 */
public interface ActionCommand {

    ServiceFactory serviceFactory = new ServiceFactory();
    
    /**
     * Execute.
     *
     * @param request the request from client
     * @param response the response for client
     * @return Next page path
     * @throws CommandException the command exception
     */
    String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException;
}
