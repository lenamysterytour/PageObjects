package demo.qa.tests;

import com.github.javafaker.Faker;
import demo.qa.TestBase;
import demo.qa.pages.RegistrationPage;
import demo.qa.pages.components.ConfirmationPage;
import demo.qa.tests.utils.FakerPage;
import org.junit.jupiter.api.Test;


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


        confirmationPage.verifyGreeting();
        confirmationPage.verifyResult("Student Name", fakeFirstName + " " + fakeLastName);
        confirmationPage.verifyResult("Student Email", fakeEmail);
        confirmationPage.verifyResult("Gender", fakeGender);
        confirmationPage.verifyResult("Mobile", fakeNumber);
        confirmationPage.verifyResult("Date of Birth", fakeBirthday + " " + fakeMonth + "," + fakeYear);
        confirmationPage.verifyResult("Subjects", fakeSubject);
        confirmationPage.verifyResult("Hobbies", fakeHobbie);
        confirmationPage.verifyResult("Picture", fakePicture);
        confirmationPage.verifyResult("Address", fakeCurrentAddress);
        confirmationPage.verifyResult("State and City", fakeState + " " + fakeCity);


    }
}