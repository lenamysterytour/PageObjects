package demo.qa.tests;

import com.github.javafaker.Faker;
import demo.qa.pages.RegistrationPage;
import demo.qa.pages.components.ConfirmationPage;
import demo.qa.tests.utils.FakerPage;
import demo.qa.tests.utils.RemoteTestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.logevents.SelenideLogger.step;

public class RegistrationRemoteTest extends RemoteTestBase {

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
            fakeMonth = FakerPage.fakeMonth(),
            confirmation = "Thanks for submitting the form";

    @Test
    @Tag("remote")
    @DisplayName("Successful registration")
    void successTest() {

        step("Open form",() -> {
        registrationPage.openPage().removeAds();});

        step("Fill form", () -> {
                    registrationPage.setFirstName(fakeFirstName)
                            .setLastName(fakeLastName)
                            .setEmail(fakeEmail)
                            .setGender(fakeGender)
                            .setNumber(fakeNumber)
                            .setBirthday(fakeMonth, fakeYear, fakeBirthday)
                            .setSubjectInput("E")
                            .setSubjectInput(fakeSubject)
                       //     .setHobbies(fakeHobbie)
                            .uploadPicture(fakePicture)
                            .setCurrentAddress(fakeCurrentAddress)
                            .setState(fakeState)
                            .setCity(fakeCity)
                            .pushSubmit();
                });

        step("Verify results", () -> {

            confirmationPage.verifyGreeting()
                    .verifyResult("Student Name", fakeFirstName + " " + fakeLastName)
                    .verifyResult("Student Email", fakeEmail)
                    .verifyResult("Gender", fakeGender)
                    .verifyResult("Mobile", fakeNumber)
                    .verifyResult("Date of Birth", fakeBirthday + " " + fakeMonth + "," + fakeYear)
                    .verifyResult("Subjects", fakeSubject)
                    .verifyResult("Hobbies", fakeHobbie)
                    .verifyResult("Picture", fakePicture)
                    .verifyResult("Address", fakeCurrentAddress)
                    .verifyResult("State and City", fakeState + " " + fakeCity);
        });
    }
}