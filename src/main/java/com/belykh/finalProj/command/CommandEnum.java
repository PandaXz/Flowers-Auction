package com.belykh.finalProj.command;

import com.belykh.finalProj.command.impl.AdminForwardCommand;
import com.belykh.finalProj.command.impl.ForwardCommand;

/**
 * Created by panda on 16.11.17.
 */
public enum CommandEnum {

    FORWARD(new ForwardCommand()),
    ADMIN_FORWARD(new AdminForwardCommand());

    CommandEnum(ActionCommand command) {
        this.command = command;
    }

    private ActionCommand command;

    public ActionCommand getCommand() {
        return command;
    }
}

