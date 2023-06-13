package demo.qa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ConfirmationPage {

    SelenideElement nameConfirmationInput = $(".table-responsive"),
            emailConfirmationInput = $(".table-responsive"),
            genderConfirmationInput = $(".table-responsive"),
            numberConfirmationInput = $(".table-responsive"),
            birthDayConfirmationInput = $(".table-responsive"),
            subjectConfirmationInput = $(".table-responsive"),
            hobbiesConfirmationInput = $(".table-responsive"),
            pictureConfirmationInput = $(".table-responsive"),
            addressConfirmationInput = $(".table-responsive"),
            stateConfirmationInput = $(".table-responsive"),
            cityConfirmationInput = $(".table-responsive");

    public ConfirmationPage nameConfirmation(String value) {
        nameConfirmationInput.shouldHave(text(value));
        return this;
    }

    public ConfirmationPage genderConfirmation(String value) {
        genderConfirmationInput.shouldHave(text(value));
        return this;
    }

    public ConfirmationPage emailConfirmation(String value) {
        emailConfirmationInput.shouldHave(text(value));
        return this;
    }

    public ConfirmationPage numberConfirmation(String value) {
        numberConfirmationInput.shouldHave(text(value));
        return this;
    }

    public ConfirmationPage birthdayConfirmation(String value) {
        birthDayConfirmationInput.shouldHave(text(value));
        return this;
    }

    public ConfirmationPage subjectConfirmation(String value) {
        subjectConfirmationInput.shouldHave(text(value));
        return this;
    }

    public ConfirmationPage hobbiesConfirmation(String value) {
        hobbiesConfirmationInput.shouldHave(text(value));
        return this;
    }

    public ConfirmationPage pictureConfirmation(String value) {
        pictureConfirmationInput.shouldHave(text(value));
        return this;
    }

    public ConfirmationPage addressConfirmation(String value) {
        addressConfirmationInput.shouldHave(text(value));
        return this;
    }

    public ConfirmationPage stateConfirmation(String value) {
        stateConfirmationInput.shouldHave(text(value));
        return this;
    }

    public ConfirmationPage cityConfirmation(String value) {
        cityConfirmationInput.shouldHave(text(value));
        return this;
    }


}
