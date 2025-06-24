package sampleProject.uiAutomation.step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import sampleProject.uiAutomation.utilities.CommonUISteps;
import sampleProject.uiAutomation.utilities.Driver;
import sampleProject.uiAutomation.utilities.Log;


public class Hooks extends Log{

    /**
     * This method notifies that the UI test has started by logging a message or displaying a warning.*/
    @Override
    public void startTestCase() {
        Log.info("---------------------------------------------------------------------------------------");
        Log.info("***********************     UI TEST STARTED    **************************");
        Log.info("---------------------------------------------------------------------------------------");
    }

    /**
    * This method logs a message to indicate the end of the UI test.*/
    @Override
    public void endTestCase() {
        Log.info("---------------------------------------------------------------------------------------");
        Log.info("***********************     UI TEST ENDED    **************************");
        Log.info("---------------------------------------------------------------------------------------");
    }

    /**
    * This method is a Cucumber Before hook that is executed before each scenario.*/
    @Before
    public void setUp() {
        startTestCase();
        Driver.getDriver();
    }

    /**
     * This method is a Cucumber After hook that is executed after each scenario.
     * It performs cleanup operations such as taking a screenshot if the scenario failed,
       and closing the WebDriver instance.*/
    @After
    public void tearDown(Scenario scenario) {
        byte[] picture;
        if (scenario.isFailed()) {
            Log.info("---------------------------------------------------------------------------------------");
            Log.error("***********************     UI TEST FAILED    **************************");
            Log.info("---------------------------------------------------------------------------------------");
            // take screenshot and save it in /failed
            picture = CommonUISteps.takeScreenshot("failed/" + scenario.getName()); // notes
            scenario.attach(picture, "image/png", scenario.getName());
        }else {
            Log.info("---------------------------------------------------------------------------------------");
            Log.info("***********************     UI TEST PASSED    **************************");
            Log.info("---------------------------------------------------------------------------------------");
        }

        endTestCase();
        Driver.closeDriver();
    }


}

