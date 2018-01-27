package com.belykh.finalProj.command;

import com.belykh.finalProj.command.impl.*;
import com.belykh.finalProj.command.impl.auction.ActualAuctionsCommand;
import com.belykh.finalProj.command.impl.lot.AcceptedLotListCommand;
import com.belykh.finalProj.command.impl.auction.AuctionsCommand;
import com.belykh.finalProj.command.impl.lot.AcceptedUserLotListCommand;

/**
 * Created by panda on 16.11.17.
 */
public enum CommandEnum {

    FORWARD(new ForwardCommand()),
    ADMIN_FORWARD(new AdminForwardCommand()),
    LOGIN(new AuthorizationCommand()),
    ENGLISH_LANGUAGE(new EnglishLanguageCommand()),
    RUSSIAN_LANGUAGE(new RussianLanguageCommand()),
    LOGOUT(new LogoutCommand()),
    SIGNUP(new SignUpCommand()),
    ACCEPTED_LOT_LIST(new AcceptedLotListCommand()),
    ACCEPTED_USER_LOT_LIST(new AcceptedUserLotListCommand());

    CommandEnum(ActionCommand command) {
        this.command = command;
    }

    private ActionCommand command;

    public ActionCommand getCommand() {
        return command;
    }
}

