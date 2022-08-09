package com.everis.base;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.chrome.ChromeDriverService;

/**
 * @author jovallep
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features",
        glue = "com.everis.base", strict = true)
public class baseTest {

    public static String ANSI_GREEN = "\u001B[32m";
    public static final String EVERIS_WELCOME =
            "-------------------------------------------------------------------------------------|\n" +
                    "-------------------------------------------------------------------------------------|\n" +
                    " ._______  __       ___ ._______  ______      __     ______       \n" +
                    " |   ____| \\  \\    /  / |  ____|  |   _  \\   |  |   /  ___|     \n" +
                    " |  |____   \\  \\  /  /  | |____   |  |_)  |  |  |  |   /          \n" +
                    " |  |____|   \\  \\/  /   |  ___|   |     /    |  |   \\  \\_         \n" +
                    " |  |____     \\ \\  /    | |____   |  |\\ \\__  |  |  __)   |       \n" +
                    " |_______|     \\__/     |_______| |__| \\___| |__| |_____/         \n" +
                    "                                                                       \n" +
                    "-------------------------------------------------------------------------------------|\n" +
                    "-------------------------------------------------------------------------------------|\n";


    @BeforeClass
    public static void messages() {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        System.out.println(ANSI_GREEN + EVERIS_WELCOME + ANSI_GREEN);
    }

    @AfterClass
    public static void message() {
        System.out.println(ANSI_GREEN + EVERIS_WELCOME + ANSI_GREEN);
    }

}
