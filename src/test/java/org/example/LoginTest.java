package org.example;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;



public class LoginTest {
    private final LocatorLoginPage locatorloginpage = new LocatorLoginPage();

    @Test
    public void testLogin() {
        open(ConfProperties.getProperty("loginpage"));
        locatorloginpage.customerButton.click();
        locatorloginpage.userSelection.selectOptionByValue("4");
        locatorloginpage.userSelection.selectOptionByValue("");
        locatorloginpage.userSelection.selectOptionByValue("5");
        locatorloginpage.loginButton.click();
        locatorloginpage.foundTextAboutUser.shouldHave(exactText("Neville Longbottom"));
    }


}
