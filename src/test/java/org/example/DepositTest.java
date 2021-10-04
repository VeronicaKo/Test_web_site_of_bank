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
        loginpage.setCustomerButton();
        loginpage.checkUrl("urlCustomer");
        loginpage.setUserSelection(customer1);
        loginpage.setUserSelection("");
        loginpage.setLoginButtonNotBe();
        loginpage.setUserSelection(customer2);
        loginpage.setLoginButton();
        loginpage.checkUrl("urlAccount");
        loginpage.setFoundTextAboutUser(customer2);

        account.setAccountSelection("number:1014");
        account.setAccountNumber("1014");
        account.setAccountBalance("0");
        account.setAccountCurrency("Pound");

        account.setDepositButton();

        account.setAmountInter("0");
        account.setDepositEnterButton();
        account.setTextDepositSuccessful();

        account.amountInter.clear();
        account.setAmountInter("1");

        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy h:mm:ss aaa",Locale.ENGLISH);
        String dateDeposit = dateFormat.format(new Date());
        account.setDepositEnterButton();
        account.setTextDepositSuccessful("Deposit successful");

        account.setTransactionsButton();
        webdriver().shouldHave(url(ConfProperties.getProperty("urlTransaction")));
        account.setTransactionDate(dateDeposit);
        account.setTransactionSum("1");
        account.setTransactionType("Credit");

    }
}
