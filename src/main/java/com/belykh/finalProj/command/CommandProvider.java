package com.belykh.finalProj.command;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by panda on 4.12.17.
 */
public class CommandProvider {

    private static final Logger LOGGER = LogManager.getLogger(CommandProvider.class);
    private static final String PARAM_COMMAND = "command";

    public ActionCommand getCommand(HttpServletRequest request) {
        ActionCommand result = new EmptyCommand();
        String command = request.getParameter(PARAM_COMMAND);
        LOGGER.log(Level.DEBUG,"command = "+command);
        if (command == null || command.isEmpty()) {
            return result;
        }
        try {
            CommandEnum commandEnum = CommandEnum.valueOf(command.toUpperCase());
            result = commandEnum.getCommand();
        } catch (IllegalArgumentException e) {

        }
        return result;
    }
}
