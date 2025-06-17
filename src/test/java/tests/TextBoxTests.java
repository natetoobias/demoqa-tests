package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000;
    }

    @Test
    void fillFormTest() {
        open("/text-box");
        $("#userName").setValue("Alex").pressEnter();
        $("#userEmail").setValue("aledefe@gmeag.com").pressEnter();
        $("#currentAddress").setValue("street 1").pressEnter();
        $("#permanentAddress").setValue("street 2").pressEnter();
        $("#submit").click();

        $("#output #name").shouldHave(text("Alex"));
        $("#output #email").shouldHave(text("aledefe@gmeag.com"));
        $("#output #currentAddress").shouldHave(text("street 1"));
        $("#output #permanentAddress").shouldHave(text("street 2"));
    }
}
