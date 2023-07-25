package demo.qa.pages.components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    public void setDate(String month, String year) {
    $(".react-datepicker__month-select").selectOption(month);
    $(".react-datepicker__year-select").selectOption(year);
//    $(".react-datepicker__day--00" + day +
//           ":not(.react-datepicker__day--outside-month)").click();
    }
}
