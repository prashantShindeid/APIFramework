package hooks;

import com.aventstack.extentreports.service.ExtentService;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;

public class hooks {

    @Before
    public void setup(){
        ExtentService.getInstance();
    }

    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            ExtentService.getInstance().addTestRunnerOutput("Scenario Failed");
        }
    }

}
