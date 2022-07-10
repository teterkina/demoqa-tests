package guru.qa.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successTest() {
        open("https://demoqa.com/text-box");

        $("#userName").setValue("Alina");
        $("#userEmail").setValue("test@email.com");
        $("#currentAddress").setValue("Some address");
        $("#permanentAddress").setValue("Another address");
        $("#submit").click();

        $("#output").shouldBe(visible);
        $("#name").shouldHave(text("Alina"));
        $("#email").shouldHave(text("test@email.com"));
        $("#output #currentAddress").shouldHave(text("Some address"));
        $("#output #permanentAddress").shouldHave(text("Another address"));
    }
}
