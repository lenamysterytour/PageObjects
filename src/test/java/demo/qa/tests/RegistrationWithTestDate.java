package demo.qa.tests;

import com.github.javafaker.Faker;
import demo.qa.TestBase;
import demo.qa.pages.RegistrationPage;
import demo.qa.pages.components.ConfirmationPage;
import demo.qa.tests.utils.FakerPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationWithTestDate extends TestBase {


    @Test
    void successTest() {

        Faker faker = new Faker();
        RegistrationPage registrationPage = new RegistrationPage();
        ConfirmationPage confirmationPage = new ConfirmationPage();

        String fakeFirstName = faker.name().firstName(),
                fakeLastName = faker.name().lastName(),
                fakeEmail = faker.internet().emailAddress(),
                fakeNumber = faker.numerify("##########"),
                fakeCurrentAddress = faker.address().fullAddress();

        String
                fakeState = FakerPage.getRandomFakerUserState(),
                fakeCity = FakerPage.getRandomFakerUserCity(fakeState),
                fakeGender = FakerPage.fakeGender(),
                fakeSubject = FakerPage.fakeSubjects(),
                fakeHobbie = FakerPage.fakeHobbies(),
                fakePicture = "Java.png",
                fakeBirthday = FakerPage.fakeBirthdays(),
                fakeYear = FakerPage.fakeYear(),
                fakeMonth = FakerPage.fakeMonth();


        registrationPage.openPage().removeAds()
                .setFirstName(fakeFirstName)
                .setLastName(fakeLastName)
                .setEmail(fakeEmail)
                .setGender(fakeGender)
                .setNumber(fakeNumber)
                .setBirthday(fakeMonth, fakeYear, fakeBirthday)
                .setSubjectInput("E")
                .setSubjectInput(fakeSubject)
                .setHobbies(fakeHobbie)
                .uploadPicture(fakePicture)
                .setCurrentAddress(fakeCurrentAddress)
                .setState(fakeState)
                .setCity(fakeCity)
                .pushSubmit();


        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        confirmationPage.nameConfirmation(fakeFirstName)
                .emailConfirmation(fakeEmail)
                .genderConfirmation(fakeGender)
                .numberConfirmation(fakeNumber)
                .birthdayConfirmation(fakeBirthday + " " + fakeMonth + "," + fakeYear)
                .subjectConfirmation(fakeSubject)
                .hobbiesConfirmation(fakeHobbie)
                .pictureConfirmation(fakePicture)
                .addressConfirmation(fakeCurrentAddress)
                .stateConfirmation(fakeState)
                .cityConfirmation(fakeCity);

    }
}