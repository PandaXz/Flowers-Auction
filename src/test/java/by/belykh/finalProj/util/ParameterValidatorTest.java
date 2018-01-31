package by.belykh.finalProj.util;

import com.belykh.finalProj.util.ParameterValidator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ParameterValidatorTest extends Assert {

    ParameterValidator parameterValidator = ParameterValidator.getInstance();
    String loginTest;
    String loginTest1;
    String passwordTest;
    String passwordTest1;
    String emailTest;
    String emailTest1;
    String nameTest;
    String nameTest1;
    String idTest;
    String idTest1;
    String priceTest;
    String priceTest1;
    String priceTest2;
    String stateTest;
    String stateTest1;
    String stateTest2;
    String datetimeTest;
    String datetimeTest1;
    String numberTest;
    String numberTest1;
    String streetTest;
    String streetTest1;
    @BeforeClass
    public void beforeClass(){
        loginTest = "Panda_Test";
        loginTest1 = "943Panda";
        passwordTest = "qweqwe123";
        passwordTest1 = "-2341w";
        emailTest = "qweqwe.qwe@gmail.com";
        emailTest1 = "qwe@@sdf";
        nameTest = "Panda";
        nameTest1 = "Pasdnwq2_";
        idTest=Long.toString(1243546l);
        idTest1=Long.toString(1243l)+"wqe";
        priceTest = "15";
        priceTest1 = "14.02";
        priceTest2 = "12.23.";
        stateTest="ACCEPTED";
        stateTest1="UNPAID";
        stateTest2="SELLD";
        datetimeTest="2018-01-04T22:22";
        datetimeTest1="01-2018-04 22:22";
        numberTest="123";
        numberTest1="1 2 q";
        streetTest="Chehova";
    }

    @Test
    public void validateLogin_PositiveTest(){
        Assert.assertTrue(parameterValidator.validateLogin(loginTest));
    }

    @Test
    public void validateLogin_NegativeTest(){
        Assert.assertFalse(parameterValidator.validateLogin(loginTest1));
    }

    @Test
    public void validatePassword_PositiveTest(){
        Assert.assertTrue(parameterValidator.validatePassword(passwordTest));
    }

    @Test
    public void validatePassword_NegativeTest(){
        Assert.assertFalse(parameterValidator.validatePassword(passwordTest1));
    }

    @Test
    public void validateEmail_PositiveTest(){
        Assert.assertTrue(parameterValidator.validateEmail(emailTest));
    }

    @Test
    public void validateEmail_NegativeTest(){
        Assert.assertFalse(parameterValidator.validateEmail(emailTest1));
    }
    @Test
    public void validateName_PositiveTest(){
        Assert.assertTrue(parameterValidator.validateName(nameTest));
    }
    @Test
    public void validateName_NegativeTest(){
        Assert.assertFalse(parameterValidator.validateName(nameTest1));
    }

    @Test
    public void validateId_PositiveTest(){
        Assert.assertTrue(parameterValidator.validateId(idTest));
    }
    @Test
    public void validateId_NegativeTest(){
        Assert.assertFalse(parameterValidator.validateId(idTest1));
    }

    @Test
    public void validatePrice_PositiveTest(){
        Assert.assertTrue(parameterValidator.validatePrice(priceTest));
    }
    @Test
    public void validatePrice_PositiveTest1(){
        Assert.assertTrue(parameterValidator.validatePrice(priceTest1));
    }
    @Test
    public void validatePrice_NegativeTest(){
        Assert.assertFalse(parameterValidator.validatePrice(priceTest2));
    }
    @Test
    public void validateState_PositiveTest(){
        Assert.assertTrue(parameterValidator.validateState(stateTest));
    }
    @Test
    public void validateState_PositiveTest1(){
        Assert.assertTrue(parameterValidator.validateState(stateTest1));
    }
    @Test
    public void validateState_NegativeTest(){
        Assert.assertFalse(parameterValidator.validateState(stateTest2));
    }

    @Test
    public void validateDateTime_PositiveTest(){
        Assert.assertTrue(parameterValidator.validateDateTime(datetimeTest));
    }
    @Test
    public void validateDateTime_NegativeTest(){
        Assert.assertFalse(parameterValidator.validateDateTime(datetimeTest1));
    }
    @Test
    public void validateNumber_PositiveTest(){
        Assert.assertTrue(parameterValidator.validateNumber(numberTest));
    }
    @Test
    public void validateNumber_NegativeTest(){
        Assert.assertFalse(parameterValidator.validateNumber(numberTest1));
    }
    @Test
    public void validateStreet_PositiveTest(){
        Assert.assertTrue(parameterValidator.validateStreet(streetTest));
    }


}
