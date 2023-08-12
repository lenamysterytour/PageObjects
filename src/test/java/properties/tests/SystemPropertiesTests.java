package properties.tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {

    @Tag("property")
    @Test
    void systemPropertiesTest(){
        String browser = System.getProperty("browser","mozilla");
        System.out.println(browser);
    }
}
