package by.belykh.finalProj.util;

import com.belykh.finalProj.util.ParameterValidator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class ParameterValidatorTest.
 */
public class ParameterValidatorTest extends Assert {

    /** The parameter validator. */
    ParameterValidator parameterValidator = ParameterValidator.getInstance();
    
    /** The login test. */
    String loginTest;
    
    /** The login test 1. */
    String loginTest1;
    
    /** The password test. */
    String passwordTest;
    
    /** The password test 1. */
    String passwordTest1;
    
    /** The email test. */
    String emailTest;
    
    /** The email test 1. */
    String emailTest1;
    
    /** The name test. */
    String nameTest;
    
    /** The name test 1. */
    String nameTest1;
    
    /** The id test. */
    String idTest;
    
    /** The id test 1. */
    String idTest1;
    
    /** The price test. */
    String priceTest;
    
    /** The price test 1. */
    String priceTest1;
    
    /** The price test 2. */
    String priceTest2;
    
    /** The state test. */
    String stateTest;
    
    /** The state test 1. */
    String stateTest1;
    
    /** The state test 2. */
    String stateTest2;
    
    /** The datetime test. */
    String datetimeTest;
    
    /** The datetime test 1. */
    String datetimeTest1;
    
    /** The number test. */
    String numberTest;
    
    /** The number test 1. */
    String numberTest1;
    
    /** The street test. */
    String streetTest;
    
    /** The street test 1. */
    String streetTest1;
    
    /**
     * Before class.
     */
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

    /**
     * Validate login positive test.
     */
    @Test
    public void validateLogin_PositiveTest(){
        Assert.assertTrue(parameterValidator.validateLogin(loginTest));
    }

    /**
     * Validate login negative test.
     */
    @Test
    public void validateLogin_NegativeTest(){
        Assert.assertFalse(parameterValidator.validateLogin(loginTest1));
    }

    /**
     * Validate password positive test.
     */
    @Test
    public void validatePassword_PositiveTest(){
        Assert.assertTrue(parameterValidator.validatePassword(passwordTest));
    }

    /**
     * Validate password negative test.
     */
    @Test
    public void validatePassword_NegativeTest(){
        Assert.assertFalse(parameterValidator.validatePassword(passwordTest1));
    }

    /**
     * Validate email positive test.
     */
    @Test
    public void validateEmail_PositiveTest(){
        Assert.assertTrue(parameterValidator.validateEmail(emailTest));
    }

    /**
     * Validate email negative test.
     */
    @Test
    public void validateEmail_NegativeTest(){
        Assert.assertFalse(parameterValidator.validateEmail(emailTest1));
    }
    
    /**
     * Validate name positive test.
     */
    @Test
    public void validateName_PositiveTest(){
        Assert.assertTrue(parameterValidator.validateName(nameTest));
    }
    
    /**
     * Validate name negative test.
     */
    @Test
    public void validateName_NegativeTest(){
        Assert.assertFalse(parameterValidator.validateName(nameTest1));
    }

    /**
     * Validate id positive test.
     */
    @Test
    public void validateId_PositiveTest(){
        Assert.assertTrue(parameterValidator.validateId(idTest));
    }
    
    /**
     * Validate id negative test.
     */
    @Test
    public void validateId_NegativeTest(){
        Assert.assertFalse(parameterValidator.validateId(idTest1));
    }

    /**
     * Validate price positive test.
     */
    @Test
    public void validatePrice_PositiveTest(){
        Assert.assertTrue(parameterValidator.validateMoney(priceTest));
    }
    
    /**
     * Validate price positive test 1.
     */
    @Test
    public void validatePrice_PositiveTest1(){
        Assert.assertTrue(parameterValidator.validateMoney(priceTest1));
    }
    
    /**
     * Validate price negative test.
     */
    @Test
    public void validatePrice_NegativeTest(){
        Assert.assertFalse(parameterValidator.validateMoney(priceTest2));
    }
    
    /**
     * Validate state positive test.
     */
    @Test
    public void validateState_PositiveTest(){
        Assert.assertTrue(parameterValidator.validateState(stateTest));
    }
    
    /**
     * Validate state positive test 1.
     */
    @Test
    public void validateState_PositiveTest1(){
        Assert.assertTrue(parameterValidator.validateState(stateTest1));
    }
    
    /**
     * Validate state negative test.
     */
    @Test
    public void validateState_NegativeTest(){
        Assert.assertFalse(parameterValidator.validateState(stateTest2));
    }

    /**
     * Validate date time positive test.
     */
    @Test
    public void validateDateTime_PositiveTest(){
        Assert.assertTrue(parameterValidator.validateDateTime(datetimeTest));
    }
    
    /**
     * Validate date time negative test.
     */
    @Test
    public void validateDateTime_NegativeTest(){
        Assert.assertFalse(parameterValidator.validateDateTime(datetimeTest1));
    }
    
    /**
     * Validate number positive test.
     */
    @Test
    public void validateNumber_PositiveTest(){
        Assert.assertTrue(parameterValidator.validateNumber(numberTest));
    }
    
    /**
     * Validate number negative test.
     */
    @Test
    public void validateNumber_NegativeTest(){
        Assert.assertFalse(parameterValidator.validateNumber(numberTest1));
    }
    
    /**
     * Validate street positive test.
     */
    @Test
    public void validateStreet_PositiveTest(){
        Assert.assertTrue(parameterValidator.validateStreet(streetTest));
    }


}
