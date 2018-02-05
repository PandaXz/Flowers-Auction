package com.belykh.finalProj.command;

import com.belykh.finalProj.command.impl.admin.*;
import com.belykh.finalProj.command.impl.common.*;
import com.belykh.finalProj.command.impl.lot.*;
import com.belykh.finalProj.command.impl.user.ChangableInfoCommand;
import com.belykh.finalProj.command.impl.user.ChangePasswordCommand;
import com.belykh.finalProj.command.impl.user.ChangeUserInfoCommand;
import com.belykh.finalProj.command.impl.user.UserInfoCommand;

// TODO: Auto-generated Javadoc
/**
 * The Enum CommandEnum.
 */
public enum CommandEnum {

    /** The forward. */
    FORWARD(new ForwardCommand()),
    
    /** The login. */
    LOGIN(new AuthorizationCommand()),
    
    /** The english language. */
    ENGLISH_LANGUAGE(new EnglishLanguageCommand()),
    
    /** The russian language. */
    RUSSIAN_LANGUAGE(new RussianLanguageCommand()),
    
    /** The logout. */
    LOGOUT(new LogoutCommand()),
    
    /** The signup. */
    SIGNUP(new SignUpCommand()),
    
    /** The accepted lot list. */
    ACCEPTED_LOT_LIST(new AcceptedLotListCommand()),
    
    /** The user lot list. */
    USER_LOT_LIST(new UserLotListCommand()),
    
    /** The user info. */
    USER_INFO(new UserInfoCommand()),
    
    /** The user info for change. */
    USER_INFO_FOR_CHANGE(new ChangableInfoCommand()),
    
    /** The change user info. */
    CHANGE_USER_INFO(new ChangeUserInfoCommand()),
    
    /** The change password. */
    CHANGE_PASSWORD(new ChangePasswordCommand()),
    
    /** The lot full. */
    LOT_FULL(new LotFullCommand()),
    
    /** The delete lot. */
    DELETE_LOT(new DeleteLotCommand()),
    
    /** The buy lot. */
    BUY_LOT(new BuyLotCommand()),
    
    /** The pay lot. */
    PAY_LOT(new PayLotCommand()),
    
    /** The offer info. */
    OFFER_INFO(new OfferInfoCommand()),
    
    /** The offer lot. */
    OFFER_LOT(new OfferLotCommand()),
    
    /** The approve lot. */
    APPROVE_LOT(new ApproveLotCommand()),
    
    /** The deny lot. */
    DENY_LOT(new DenyLotCommand()),
    
    /** The added lots. */
    ADDED_LOTS(new AddedLotsCommand()),
    
    /** The change balance. */
    CHANGE_BALANCE(new ChangeBalanceCommand()),
    
    /** The add flower. */
    ADD_FLOWER(new AddFlowerCommand()),
    
    /** The add city. */
    ADD_CITY(new AddCityCommand()),
    
    /** The user list. */
    USER_LIST(new UserListCommand());

    /**
     * Instantiates a new command enum.
     *
     * @param command the command
     */
    CommandEnum(ActionCommand command) {
        this.command = command;
    }

    private ActionCommand command;

    /**
     * Gets the command.
     *
     * @return the command
     */
    public ActionCommand getCommand() {
        return command;
    }
}

