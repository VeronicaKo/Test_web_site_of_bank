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
        loginpage.setCustomerButton();
        loginpage.checkUrl("urlCustomer");
        loginpage.setUserSelection(customer1);
        loginpage.setUserSelection("");
        loginpage.setLoginButtonNotBe();
        loginpage.setUserSelection(customer2);
        loginpage.setLoginButton();
        loginpage.checkUrl("urlAccount");
        loginpage.setFoundTextAboutUser(customer2);
    }


}
