package com.belykh.finalProj.constant;

/**
 * Created by panda on 6.12.17.
 */
public enum PathPage {
    LOGIN("/jsp/login.jsp"),
    INDEX("/index.jsp"),
    MAIN("/jsp/main.jsp"),
    ERROR("/jsp/error.jsp"),
    REGISTRATION("/jsp/registration.jsp"),
    AUCTION("/jsp/auction.jsp"),
    USER_LOTS("/jsp/lot/user_lots.jsp"),
    LOT_INFORMATION("/jsp/lot/lot_full.jsp"),
    USER_INFORMATION("/jsp/user/user_info.jsp"),
    CHANGE_USER_INFO("/jsp/user/change_user_info.jsp"),
    CHANGE_PASSWORD("/jsp/user/change_password.jsp"),
    OFFER_LOT("/jsp/lot/offer_lot.jsp"),
    ADDED_LOTS("/jsp/admin/added_lots.jsp");

    private String path;
    private PathPage(String path) {
        this.path= path;
    }

    public String getPath() {
        return path;
    }
}
