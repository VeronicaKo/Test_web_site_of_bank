package org.example;

import com.codeborne.selenide.Conditional;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class LocatorAccount {
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


}