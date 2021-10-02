import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.CollectionCondition.*;

public class LoginTest {
    @Test
    void testLogin() {
        open("https://www.globalsqa.com/angularJs-protractor/BankingProject/");
        $(byCssSelector("button[ng-click='customer()']")).click();
        $(byId("userSelect")).selectOptionByValue("4");
        $(byId("userSelect")).selectOptionByValue("");
        $(byId("userSelect")).selectOptionByValue("5");
        sleep(30);
        $(byClassName(".btn.btn-default")).click();
        $(byCssSelector(".fontBig.ng-binding")).shouldHave(exactText("Neville Longbottom"));
        $(byCssSelector("button[ng-click='transactions()']")).click();



    }


}
