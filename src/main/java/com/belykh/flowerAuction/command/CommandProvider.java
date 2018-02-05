package com.belykh.flowerAuction.command;

import com.belykh.flowerAuction.command.impl.EmptyCommand;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * The Class CommandProvider.
 */
public class CommandProvider {

    private static final Logger LOGGER = LogManager.getLogger(CommandProvider.class);
    private static final String PARAM_COMMAND = "command";

    /**
     * Gets the command.
     *
     * @param request the request from client
     * @return the command
     */
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
        } catch (IllegalArgumentException ignored){}
        return result;
    }
}
