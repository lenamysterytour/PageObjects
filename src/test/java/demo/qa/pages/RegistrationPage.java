package demo.qa.pages;

import com.codeborne.selenide.SelenideElement;
import demo.qa.pages.components.CalendarComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    CalendarComponent calendarComponent = new CalendarComponent();

SelenideElement firstNameInput = $("#firstName"),
 secondNameInput =$("#lastName"),
userEmail =  $("#userEmail"),
 genderWrapper =   $("#genterWrapper"),

    setNumber =  $("#userNumber"),

           birthDayInput = $("#dateOfBirthInput") ;

    public RegistrationPage openPage(){
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
        }

public RegistrationPage setFirstName(String value){
    firstNameInput.setValue(value);
    return this;}
public RegistrationPage setLastName(String value){
        secondNameInput.setValue(value);
    return this;}
public RegistrationPage setEmail(String value){
        userEmail.setValue(value);
    return this;}
public RegistrationPage setGender(String value){
        genderWrapper.$(byText(value)).click();;
    return this;}
    public RegistrationPage setNumber (String value){
        setNumber.setValue(value);
        return this;}
    public RegistrationPage setBirthday (String month, String year, String day){
        birthDayInput.click();
        calendarComponent.setDate(month, year, day);
    return this;}


}
