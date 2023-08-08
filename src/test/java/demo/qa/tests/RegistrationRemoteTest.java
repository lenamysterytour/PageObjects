package demo.qa.tests;

import com.github.javafaker.Faker;
import demo.qa.pages.RegistrationPage;
import demo.qa.pages.components.ConfirmationPage;
import demo.qa.tests.utils.FakerPage;
import demo.qa.tests.utils.RemoteTestBase;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("remote")
public class RegistrationRemoteTest extends RemoteTestBase {

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
                fakeMonth = FakerPage.fakeMonth(),
                confirmation = "Thanks for submitting the form";


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

    }
}