package org.example;

import com.codeborne.selenide.Conditional;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Account {
    public SelenideElement accountSelection = $(By.id("accountSelect"));
    public SelenideElement accountNumber = $$(By.className("ng-binding")).get(1);
    public SelenideElement accountBalance = $$(By.className("ng-binding")).get(2);
    public SelenideElement accountCurrency = $$(By.className("ng-binding")).get(3);

    public SelenideElement depositButton = $("button[ng-click='deposit()']");
    public SelenideElement amountInter = $("input[ng-model='amount']");
    public SelenideElement depositEnterButton = $(By.className("btn-default"));
    public SelenideElement textDepositSuccessful = $((".error.ng-binding"));
    public SelenideElement transactionsButton = $("button[ng-click='transactions()']");
    public SelenideElement transactionDate = $$(By.className("ng-binding")).get(0);
    public SelenideElement transactionSum = $$(By.className("ng-binding")).get(1);
    public SelenideElement transactionType = $$(By.className("ng-binding")).get(2);


    public void enterAccountSelection(String accSelection) {
        accountSelection.selectOptionByValue(accSelection);
    }

    public void checkAccountNumber(String accNumber) {
        accountNumber.shouldHave(exactText(accNumber));
    }

    public void checkAccountBalance(String accBalance) {
        accountBalance.shouldHave(exactText(accBalance));
    }

    public void checkAccountCurrency(String accCurrency) {
        accountCurrency.shouldHave(exactText(accCurrency));
    }

    public void clickDepositButton() {
        depositButton.click();
    }

    public void enterAmountInter(String amInter) {
        amountInter.sendKeys(amInter);
    }

    public void clickDepositEnterButton() {
        depositEnterButton.click();
    }

    public void noTextDepositSuccessful() {
        textDepositSuccessful.shouldNotBe(visible);
    }

    public void clickTransactionsButton() {
        transactionsButton.click();
    }

    public void YesTextDepositSuccessful(String textDepSuccessful) {
        textDepositSuccessful.shouldHave(exactText(textDepSuccessful));
    }

    public void checkTransactionDate(String trDate) {
        transactionDate.shouldHave(exactText(trDate));
    }

    public void checkTransactionSum(String trSum) {
        transactionSum.shouldHave(exactText(trSum));
    }

    public void checkTransactionType(String trType) {
        transactionType.shouldHave(exactText(trType));
    }
}