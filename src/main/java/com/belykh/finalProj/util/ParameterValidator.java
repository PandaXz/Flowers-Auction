package com.belykh.finalProj.util;

import com.belykh.finalProj.entity.dbo.LotState;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParameterValidator {

    private static ParameterValidator intstance = new ParameterValidator();

    private static final Pattern REGEX_LOGIN=Pattern.compile("^[A-Za-z][A-Za-z_]*$");
    private static final Pattern REGEX_PASSWORD=Pattern.compile("^\\w+$");
    private static final Pattern REGEX_EMAIL=Pattern.compile("^[\\w\\.]+@\\w+\\.\\w+$");
    private static final Pattern REGEX_NAME=Pattern.compile("^[A-Za-z]*$");
    private static final Pattern REGEX_ID=Pattern.compile("^\\d+$");
    private static final Pattern REGEX_PRICE=Pattern.compile("^\\d+(\\.\\d{1,4})?");
    private static final Pattern REGEX_DATETIME=Pattern.compile("^(\\d{4,})-(\\d{2})-(\\d{2})[T ](\\d{2}):(\\d{2})(?::(\\d{2}(?:\\.\\d+)?))?$");
    private static final Pattern REGEX_NUMBER=Pattern.compile("^\\d+$");
    private static final Pattern REGEX_STREET=Pattern.compile("^[\\w-]+$");

    private ParameterValidator() {
    }
    public static ParameterValidator getInstance() {
        return intstance;
    }

    public boolean validateLogin(String login){
        return checkString(login, REGEX_LOGIN);
    }

    public boolean validatePassword(String password){
        return checkString(password, REGEX_PASSWORD);
    }

    public boolean validateEmail(String email){
        return checkString(email, REGEX_EMAIL);
    }

    public boolean validateName(String name){
        return checkString(name, REGEX_NAME);
    }

    public boolean validateId(String id){
        return checkString(id, REGEX_ID);
    }

    public boolean validatePrice(String price){
        return checkString(price, REGEX_PRICE);
    }

    public boolean validateDateTime(String datetime){return  checkString(datetime,REGEX_DATETIME);}

    public boolean validateNumber(String number){return  checkString(number,REGEX_NUMBER);}

    public boolean validateStreet(String street){return  checkString(street,REGEX_STREET);}

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
