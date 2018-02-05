package com.belykh.flowerAuction.command;

import com.belykh.flowerAuction.command.impl.admin.*;
import com.belykh.flowerAuction.command.impl.common.*;
import com.belykh.flowerAuction.command.impl.lot.*;
import com.belykh.flowerAuction.command.impl.user.ChangePasswordCommand;
import com.belykh.flowerAuction.command.impl.user.ChangeUserInfoCommand;
import com.belykh.flowerAuction.command.impl.user.ChangeableInfoCommand;
import com.belykh.flowerAuction.command.impl.user.UserInfoCommand;

/**
 * The Enum CommandEnum.
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
    USER_INFO_FOR_CHANGE(new ChangeableInfoCommand()),
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

    /**
     * Instantiates a new command enum.
     *
     * @param command Object that contain handler for command
     */
    CommandEnum(ActionCommand command) {
        this.command = command;
    }

    private ActionCommand command;

    /**
     * Gets the handler.
     *
     * @return the command
     */
    public ActionCommand getCommand() {
        return command;
    }
}

