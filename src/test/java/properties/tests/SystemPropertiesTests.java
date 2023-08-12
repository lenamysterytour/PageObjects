package properties.tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static java.lang.String.format;

public class SystemPropertiesTests {

    @Tag("property")
    @Test
    void systemPropertiesTest(){
        String browser = System.getProperty("browser","mozilla");
        System.out.println(browser);
    }

    @Tag("hello")
    @Test
    void systemProperties1Test(){
        String name = System.getProperty("name","default student");
        String message = format("Hello, %s!", name);
        System.out.println(message);

        // gradle hello_test - Dname="Elena Bolotnikova"
    }
}
