package org.example;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LocatorLoginPage {
    public SelenideElement customerButton = $("button[ng-click='customer()']");
    public SelenideElement userSelection = $(By.id("userSelect"));
    public SelenideElement loginButton = $(By.className("btn-default"));
    public SelenideElement foundTextAboutUser = $("span.fontBig.ng-binding");

}
