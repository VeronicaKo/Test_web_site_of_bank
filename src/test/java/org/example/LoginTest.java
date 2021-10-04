package org.example;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.WebDriverConditions.*;


public class LoginTest {
    private final LocatorLoginPage locatorloginpage = new LocatorLoginPage();

    @Test
    public void testLogin() {
        open(ConfProperties.getProperty("loginpage"));
        locatorloginpage.customerButton.click();
        webdriver().shouldHave(url("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/customer"));
        locatorloginpage.userSelection.selectOptionByValue("4");
        locatorloginpage.userSelection.selectOptionByValue("");
        locatorloginpage.userSelection.selectOptionByValue("5");
        locatorloginpage.loginButton.click();
        webdriver().shouldHave(url("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/account"));
        locatorloginpage.foundTextAboutUser.shouldHave(exactText("Neville Longbottom"));
    }


}
