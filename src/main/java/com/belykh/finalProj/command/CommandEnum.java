package com.belykh.finalProj.command;

import com.belykh.finalProj.command.impl.*;
import com.belykh.finalProj.command.impl.auction.ActualAuctionsCommand;
import com.belykh.finalProj.command.impl.auction.AuctionFullCommand;
import com.belykh.finalProj.command.impl.auction.AuctionsCommand;

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
    ACTUAL_AUCTION_LIST(new ActualAuctionsCommand()),
    AUCTION_LIST(new AuctionsCommand()),
    AUCTION_FULL(new AuctionFullCommand());

    CommandEnum(ActionCommand command) {
        this.command = command;
    }

    private ActionCommand command;

    public ActionCommand getCommand() {
        return command;
    }
}

