package org.example;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.*;


public class LoginTest {
    private final LoginPage loginpage = new LoginPage();

    @Test
    public void testLogin() {
        String customer1 = "Albus Dumbledore";
        String customer2 = "Neville Longbottom";
        open(ConfProperties.getProperty("loginpage"));
        loginpage.clickCustomerButton();
        loginpage.checkUrl("urlCustomer");
        loginpage.enterUserSelection(customer1);
        loginpage.enterUserSelection("");
        loginpage.loginButtonNotBe();
        loginpage.enterUserSelection(customer2);
        loginpage.clickLoginButton();
        loginpage.checkUrl("urlAccount");
        loginpage.foundTextAboutUser(customer2);
    }


}
