package stepDefinitions;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageObjects.LoginPage;
import pageObjects.SignUpPage;

public class BaseClass {

    public WebDriver driver;
    public LoginPage lp;
    public SignUpPage signup;
    public static Logger logger;
    Properties configProp;

}

