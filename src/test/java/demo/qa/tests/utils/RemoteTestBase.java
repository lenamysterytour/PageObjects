package demo.qa.tests.utils;

import com.codeborne.selenide.logevents.SelenideLogger;
import demo.qa.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class RemoteTestBase {
    @BeforeAll
    static void beforeAll() {
   //     Configuration.browser = "chrome";
//        Configuration.browserSize = "1920x1080";
//        Configuration.baseUrl = "https://demoqa.com";
//
//        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

        Configuration.browser = System.getProperty("browser","chrome");
        Configuration.baseUrl =System.getProperty("baseUrl","https://demoqa.com");
        Configuration.browserSize=System.getProperty("browserSize","360x800");
        Configuration.browserVersion=System.getProperty("browserVersion","100.0");
        Configuration.remote =System.getProperty("remoteUrl","https://user1:1234@selenoid.autotests.cloud/wd/hub/");




        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object> of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;

    }

@BeforeEach
    void addListener(){
    SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
}

@AfterEach
    void addAttachments(){
    Attach.screenshotAs("Last screenshot");
    Attach.pageSource();
    Attach.browserConsoleLogs();
    Attach.addVideo();

}
}