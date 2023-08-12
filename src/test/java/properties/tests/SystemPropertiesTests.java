package properties.tests;

import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {

    @Test
    void systemPropertiesTest(){
        String browser = System.getProperty("browser","mozilla");
        System.out.println(browser);
    }
}
