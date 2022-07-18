package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "400x706";
    }

    @Test
    void successTest() {
        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue("Alina");
        $("#lastName").setValue("Teterkina");
        $("#userEmail").setValue("test@email.com");
        $(byText("Female")).click();
        $("#userNumber").setValue("3576001288");
        $(byId("dateOfBirthInput")).scrollIntoView(true).click();
        $(byClassName("react-datepicker__month-select")).selectOption("June");
        $(byClassName("react-datepicker__year-select")).selectOption("1991");
        $(byClassName("react-datepicker__day--025")).click();
        $(byId("subjectsInput")).setValue("Che");
        $(byText("Chemistry")).click();
        $("#uploadPicture").uploadFromClasspath("hello.txt");
        $(byText("Reading")).click();
        $("#currentAddress").setValue("Cyprus");
        $(byId("stateCity-wrapper")).scrollIntoView(true).click();
        $(byText("NCR")).click();
        $(byId("city")).click();
        $(byText("Delhi")).click();
        $("#submit").click();

        $(byClassName("modal-content")).shouldBe(visible);
        $(byClassName("table-responsive")).shouldHave(text("Student Name Alina Teterkina"),
                text("Student Email test@email.com" ),
                text("Gender Female"),
                text("Mobile 3576001288"),
                text("Date of Birth 25 June,1991"),
                text("Subjects Chemistry"),
                text("Hobbies Reading"),
                text("Picture hello.txt"),
                text("Address Cyprus"),
                text("State and City NCR Delhi")
        );
    }
}

