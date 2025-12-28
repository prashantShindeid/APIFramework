package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "steps",
        plugin = {
                "pretty",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",     // Allure
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" // Extent
        },
        tags = "@Smoke"
)
public class TestRunner extends AbstractTestNGCucumberTests {

}
