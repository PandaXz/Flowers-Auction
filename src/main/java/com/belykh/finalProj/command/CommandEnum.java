package com.belykh.finalProj.command;

import com.belykh.finalProj.command.impl.*;
import com.belykh.finalProj.command.impl.lot.*;
import com.belykh.finalProj.command.impl.user.ChangePasswordCommand;
import com.belykh.finalProj.command.impl.user.ChangeUserInfoCommand;
import com.belykh.finalProj.command.impl.user.UserInfoCommand;
import com.belykh.finalProj.command.impl.user.UserInfoForChangeCommand;

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
    USER_LOT_LIST(new UserLotListCommand()),
    USER_INFO(new UserInfoCommand()),
    USER_INFO_FOR_CHANGE(new UserInfoForChangeCommand()),
    CHANGE_USER_INFO(new ChangeUserInfoCommand()),
    CHANGE_PASSWORD(new ChangePasswordCommand()),
    LOT_FULL(new LotFullCommand()),
    DELETE_LOT(new DeleteLotCommand()),
    BUY_LOT(new BuyLotCommand());

    CommandEnum(ActionCommand command) {
        this.command = command;
    }

    private ActionCommand command;

    public ActionCommand getCommand() {
        return command;
    }
}

