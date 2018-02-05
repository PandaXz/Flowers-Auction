package com.belykh.finalProj.constant;

// TODO: Auto-generated Javadoc
/**
 * The Enum PathPage.
 */
public enum PathPage {
    
    /** The login. */
    LOGIN("/jsp/login.jsp"),
    
    /** The index. */
    INDEX("/index.jsp"),
    
    /** The main. */
    MAIN("/jsp/main.jsp"),
    
    /** The error. */
    ERROR("/jsp/error.jsp"),
    
    /** The registration. */
    REGISTRATION("/jsp/registration.jsp"),
    
    /** The auction. */
    AUCTION("/jsp/auction.jsp"),
    
    /** The user lots. */
    USER_LOTS("/jsp/lot/user-lots.jsp"),
    
    /** The lot information. */
    LOT_INFORMATION("/jsp/lot/lot-info.jsp"),
    
    /** The user information. */
    USER_INFORMATION("/jsp/user/user-info.jsp"),
    
    /** The change user info. */
    CHANGE_USER_INFO("/jsp/user/change-user-info.jsp"),
    
    /** The change password. */
    CHANGE_PASSWORD("/jsp/user/change-password.jsp"),
    
    /** The offer lot. */
    OFFER_LOT("/jsp/lot/offer-lot.jsp"),
    
    /** The added lots. */
    ADDED_LOTS("/jsp/admin/added-lots.jsp"),
    
    /** The add city. */
    ADD_CITY("/jsp/admin/add-city.jsp"),
    
    /** The add flower. */
    ADD_FLOWER("/jsp/admin/add-flower.jsp"),
    
    /** The user list. */
    USER_LIST("/jsp/admin/user-list.jsp");

    private String path;
    private PathPage(String path) {
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
