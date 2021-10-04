package org.example;

import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.*;

public class DepositTest {
    private final Account account = new Account();
    private final LoginPage loginpage = new LoginPage();

    @Test
    public void testDeposit(){
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

        account.enterAccountSelection("number:1014");
        account.checkAccountNumber("1014");
        account.checkAccountBalance("0");
        account.checkAccountCurrency("Pound");

        account.clickDepositButton();

        account.enterAmountInter("0");
        account.clickDepositEnterButton();
        account.noTextDepositSuccessful();

        account.amountInter.clear();
        account.enterAmountInter("1");

        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy h:mm:ss aaa",Locale.ENGLISH);
        String dateDeposit = dateFormat.format(new Date());
        account.clickDepositEnterButton();
        account.YesTextDepositSuccessful("Deposit successful");

        account.clickTransactionsButton();
        webdriver().shouldHave(url(ConfProperties.getProperty("urlTransaction")));
        account.checkTransactionDate(dateDeposit);
        account.checkTransactionSum("1");
        account.checkTransactionType("Credit");

    }
}
