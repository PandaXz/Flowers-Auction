package com.belykh.flowerAuction.constant;

/**
 * The Enum PathPage.
 */
public enum PathPage {
    
    LOGIN("/jsp/login.jsp"),
    INDEX("/index.jsp"),
    MAIN("/jsp/main.jsp"),
    ERROR("/jsp/error.jsp"),
    REGISTRATION("/jsp/registration.jsp"),
    AUCTION("/jsp/auction.jsp"),
    USER_LOTS("/jsp/lot/user-lots.jsp"),
    LOT_INFORMATION("/jsp/lot/lot-info.jsp"),
    USER_INFORMATION("/jsp/user/user-info.jsp"),
    CHANGE_USER_INFO("/jsp/user/change-user-info.jsp"),
    CHANGE_PASSWORD("/jsp/user/change-password.jsp"),
    OFFER_LOT("/jsp/lot/offer-lot.jsp"),
    ADDED_LOTS("/jsp/admin/added-lots.jsp"),
    ADD_CITY("/jsp/admin/add-city.jsp"),
    ADD_FLOWER("/jsp/admin/add-flower.jsp"),
    USER_LIST("/jsp/admin/user-list.jsp");

    private String path;
    PathPage(String path) {
        this.path= path;
    }

    /**
     * Gets the path.
     *
     * @return the path
     */
    public String getPath() {
        return path;
    }
}
