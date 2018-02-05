package com.belykh.flowerAuction.util;

import com.belykh.flowerAuction.entity.dto.LotState;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The Class ParameterValidator.
 */
public class ParameterValidator {

    private static ParameterValidator instance = new ParameterValidator();

    private static final Pattern REGEX_LOGIN=Pattern.compile("^[A-Za-z][A-Za-z_]*$");
    private static final Pattern REGEX_PASSWORD=Pattern.compile("^\\w+$");
    private static final Pattern REGEX_EMAIL=Pattern.compile("^[\\w\\.]+@\\w+\\.\\w+$");
    private static final Pattern REGEX_NAME=Pattern.compile("^[A-Za-zА-Яа-я-]*$");
    private static final Pattern REGEX_ID=Pattern.compile("^\\d+$");
    private static final Pattern REGEX_PRICE=Pattern.compile("^\\d+(\\.\\d{1,4})?");
    private static final Pattern REGEX_DATETIME=Pattern.compile("^(\\d{4,})-(\\d{2})-(\\d{2})[T ](\\d{2}):(\\d{2})(?::(\\d{2}(?:\\.\\d+)?))?$");
    private static final Pattern REGEX_NUMBER=Pattern.compile("^\\d+$");
    private static final Pattern REGEX_STREET=Pattern.compile("^[\\wА-Яа-я-]+$");

    private ParameterValidator() {
    }
    
    /**
     * Gets the single instance of ParameterValidator.
     *
     * @return single instance of ParameterValidator
     */
    public static ParameterValidator getInstance() {
        return instance;
    }

    /**
     * Validate login.
     *
     * @param login the login
     * @return true, if successful
     */
    public boolean validateLogin(String login){
        return checkString(login, REGEX_LOGIN);
    }

    /**
     * Validate password.
     *
     * @param password the password
     * @return true, if successful
     */
    public boolean validatePassword(String password){
        return checkString(password, REGEX_PASSWORD);
    }

    /**
     * Validate email.
     *
     * @param email the email
     * @return true, if successful
     */
    public boolean validateEmail(String email){
        return checkString(email, REGEX_EMAIL);
    }

    /**
     * Validate name.
     *
     * @param name the name
     * @return true, if successful
     */
    public boolean validateName(String name){
        return checkString(name, REGEX_NAME);
    }

    /**
     * Validate id.
     *
     * @param id the id
     * @return true, if successful
     */
    public boolean validateId(String id){
        return checkString(id, REGEX_ID);
    }

    /**
     * Validate money.
     *
     * @param price the price
     * @return true, if successful
     */
    public boolean validateMoney(String price){
        return checkString(price, REGEX_PRICE);
    }

    /**
     * Validate date time.
     *
     * @param datetime the datetime
     * @return true, if successful
     */
    public boolean validateDateTime(String datetime){return  checkString(datetime,REGEX_DATETIME);}

    /**
     * Validate number.
     *
     * @param number the number
     * @return true, if successful
     */
    public boolean validateNumber(String number){return  checkString(number,REGEX_NUMBER);}

    /**
     * Validate street.
     *
     * @param street the street
     * @return true, if successful
     */
    public boolean validateStreet(String street){return  checkString(street,REGEX_STREET);}

    /**
     * Validate state.
     *
     * @param state the state
     * @return true, if successful
     */
    public boolean validateState(String state){
        if (state == null || state.isEmpty()) {
            return false;
        }
        for(LotState lotState: LotState.values()){
            if(lotState.name().equals(state.toUpperCase())){
                return true;
            }
        }
        return false;
    }

    private boolean checkString(String str, Pattern regex) {
        if (str == null || str.isEmpty()|| regex == null) {
            return false;
        }
        Matcher m = regex.matcher(str.trim());
        return m.matches();
    }

}
