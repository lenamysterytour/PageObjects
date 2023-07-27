package demo.qa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ConfirmationPage {

    SelenideElement confirMantionTable = $(".table-responsive"),
            greetingText = $("#example-modal-sizes-title-lg");

    public ConfirmationPage verifyGreeting() {
        greetingText.shouldHave(text("Thanks for submitting the form"));
        return this;
    }

    public ConfirmationPage verifyResult(String key, String value) {
        confirMantionTable.$(byText(key)).sibling(0).shouldHave(text(value));
    return this;}


        public ConfirmationPage nameConfirmation (String value){
            confirMantionTable.shouldHave(text(value));
            return this;
        }

        public ConfirmationPage genderConfirmation (String value){
            confirMantionTable.shouldHave(text(value));
            return this;
        }

        public ConfirmationPage emailConfirmation (String value){
            confirMantionTable.shouldHave(text(value));
            return this;
        }

        public ConfirmationPage numberConfirmation (String value){
            confirMantionTable.shouldHave(text(value));
            return this;
        }

        public ConfirmationPage birthdayConfirmation (String value){
            confirMantionTable.shouldHave(text(value));
            return this;
        }

        public ConfirmationPage subjectConfirmation (String value){
            confirMantionTable.shouldHave(text(value));
            return this;
        }

        public ConfirmationPage hobbiesConfirmation (String value){
            confirMantionTable.shouldHave(text(value));
            return this;
        }

        public ConfirmationPage pictureConfirmation (String value){
            confirMantionTable.shouldHave(text(value));
            return this;
        }

        public ConfirmationPage addressConfirmation (String value){
            confirMantionTable.shouldHave(text(value));
            return this;
        }

        public ConfirmationPage stateConfirmation (String value){
            confirMantionTable.shouldHave(text(value));
            return this;
        }

        public ConfirmationPage cityConfirmation (String value){
            confirMantionTable.shouldHave(text(value));
            return this;
        }


    }