package com.belykh.finalProj.command;

import com.belykh.finalProj.command.impl.admin.*;
import com.belykh.finalProj.command.impl.common.*;
import com.belykh.finalProj.command.impl.lot.*;
import com.belykh.finalProj.command.impl.user.ChangableInfoCommand;
import com.belykh.finalProj.command.impl.user.ChangePasswordCommand;
import com.belykh.finalProj.command.impl.user.ChangeUserInfoCommand;
import com.belykh.finalProj.command.impl.user.UserInfoCommand;

/**
 * Created by panda on 16.11.17.
 */
public enum CommandEnum {

    FORWARD(new ForwardCommand()),
    LOGIN(new AuthorizationCommand()),
    ENGLISH_LANGUAGE(new EnglishLanguageCommand()),
    RUSSIAN_LANGUAGE(new RussianLanguageCommand()),
    LOGOUT(new LogoutCommand()),
    SIGNUP(new SignUpCommand()),
    ACCEPTED_LOT_LIST(new AcceptedLotListCommand()),
    USER_LOT_LIST(new UserLotListCommand()),
    USER_INFO(new UserInfoCommand()),
    USER_INFO_FOR_CHANGE(new ChangableInfoCommand()),
    CHANGE_USER_INFO(new ChangeUserInfoCommand()),
    CHANGE_PASSWORD(new ChangePasswordCommand()),
    LOT_FULL(new LotFullCommand()),
    DELETE_LOT(new DeleteLotCommand()),
    BUY_LOT(new BuyLotCommand()),
    PAY_LOT(new PayLotCommand()),
    OFFER_INFO(new OfferInfoCommand()),
    OFFER_LOT(new OfferLotCommand()),
    APPROVE_LOT(new ApproveLotCommand()),
    DENY_LOT(new DenyLotCommand()),
    ADDED_LOTS(new AddedLotsCommand()),
    CHANGE_BALANCE(new ChangeBalanceCommand()),
    ADD_FLOWER(new AddFlowerCommand()),
    ADD_CITY(new AddCityCommand()),
    USER_LIST(new UserListCommand());

    CommandEnum(ActionCommand command) {
        this.command = command;
    }

    private ActionCommand command;

    public ActionCommand getCommand() {
        return command;
    }
}

