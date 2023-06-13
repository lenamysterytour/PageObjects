package demo.qa;


import demo.qa.pages.RegistrationPage;
import demo.qa.pages.components.ConfirmationPage;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPageWithPageObjects extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    ConfirmationPage confirmationPage = new ConfirmationPage();

    @Test
    void successTest() {
        registrationPage.openPage()
                .setFirstName("Vasya")
                .setLastName("Pupkin")
                .setEmail("vasya@pupkin.ru")
                .setGender("Male")
                .setNumber("2741001274")
                .setBirthday("July", "2008", "1")
                .setSubjectInput("English")
                .setHobbies("Reading")
                .uploadPicture("Java.png")
                .setCurrentAdress("Kazansky Vokzal")
                .setState("NCR")
                .setCity("Gurgaon")
                .pushSubmit();
        confirmationPage
                .nameConfirmation("Vasya Pupkin")
                .emailConfirmation("vasya@pupkin.ru")
                .genderConfirmation("Male")
                .numberConfirmation("2741001274")
                .birthdayConfirmation("1 July,2008")
                .subjectConfirmation("English")
                .hobbiesConfirmation("Reading")
                .pictureConfirmation("Java.png")
                .addressConfirmation("Kazansky vokzal")
                .stateConfirmation("NCR")
                .cityConfirmation("Gurgaon");
    }
}
