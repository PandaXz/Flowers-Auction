package com.belykh.finalProj.command;

import com.belykh.finalProj.exception.CommandException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by panda on 16.11.17.
 */
public interface ActionCommand {
    String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException;
}
