package demo.qa;


import demo.qa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPageWithPageObjects extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successTest() {
        registrationPage.openPage()
                .setFirstName("Vasya")
                .setLastName("Pupkin")
                .setEmail("vasya@punpkin.ru")
                .setGender("Male")
                .setNumber("2741001274")
                .setBirthday("July", "2008", "1")
                .setSubjectInput("English")
                .setHobbies("Reading")
                .uploadPicture("Java.png")
                .setCurrentAdress("Kazansky Vokzal")
                .setState("NCR")
                .setCity("Gurgaon");
        $("#submit").click();


        $(".table-responsive").shouldHave(text("Vasya Pupkin"));
        $(".table-responsive").shouldHave(text("vasya@pupkin.com"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("2741001274"));
        $(".table-responsive").shouldHave(text("1 June,2023"));
        $(".table-responsive").shouldHave(text("English"));
        $(".table-responsive").shouldHave(text("Kazansky vokzal"));
        $(".table-responsive").shouldHave(text("NCR"));
        $(".table-responsive").shouldHave(text("Gurgaon"));


    }
}
