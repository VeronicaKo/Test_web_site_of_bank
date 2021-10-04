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
    private final LocatorAccount locatoraccount = new LocatorAccount();
    private final LocatorLoginPage locatorloginpage = new LocatorLoginPage();

    @Test
    public void testDeposit(){
        open(ConfProperties.getProperty("loginpage"));
        locatorloginpage.customerButton.click();
        webdriver().shouldHave(url(ConfProperties.getProperty("urlCustomer")));
        locatorloginpage.userSelection.selectOptionByValue("4");
        locatorloginpage.userSelection.selectOptionByValue("");
        locatorloginpage.userSelection.selectOptionByValue("5");
        locatorloginpage.loginButton.click();
        webdriver().shouldHave(url(ConfProperties.getProperty("urlAccount")));
        locatorloginpage.foundTextAboutUser.shouldHave(exactText("Neville Longbottom"));

        locatoraccount.accountSelection.selectOptionByValue("number:1014");
        locatoraccount.accountNumber.shouldHave(exactText("1014"));
        locatoraccount.accountBalance.shouldHave(exactText("0"));
        locatoraccount.accountCurrency.shouldHave(exactText("Pound"));

        locatoraccount.depositButton.click();

        locatoraccount.amountInter.sendKeys("0");
        locatoraccount.depositEnterButton.click();
        locatoraccount.textDepositSuccessful.shouldNotBe(visible);

        locatoraccount.amountInter.clear();
        locatoraccount.amountInter.sendKeys("1");

        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy h:mm:ss aaa",Locale.ENGLISH);
        String dateDeposit = dateFormat.format(new Date());
        locatoraccount.depositEnterButton.click();
        locatoraccount.textDepositSuccessful.shouldHave(exactText("Deposit successful"));

        locatoraccount.transactionsButton.click();
        webdriver().shouldHave(url(ConfProperties.getProperty("urlTransaction")));
        locatoraccount.transactionDate.shouldHave(exactText(dateDeposit));
        locatoraccount.transactionSum.shouldHave(exactText("1"));
        locatoraccount.transactionType.shouldHave(exactText("Credit"));

    }
}
