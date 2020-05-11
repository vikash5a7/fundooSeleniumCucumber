package stepDefinitions;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageObjects.LoginPage;

import java.util.Properties;

public class BaseClass {

    public WebDriver driver;
    public LoginPage lp;
   
    public static Logger logger;
    Properties configProp;


    //Created for generating random string for Unique email
    public static String randomestring() {
        String generatedString1 = RandomStringUtils.randomAlphabetic(5);
        return (generatedString1);
    }

}

