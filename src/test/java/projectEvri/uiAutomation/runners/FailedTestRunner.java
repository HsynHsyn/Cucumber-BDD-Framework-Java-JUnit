package projectEvri.uiAutomation.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


/**
 * This class is a test runner specifically designed to execute failed Cucumber tests.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/failed-html-report"},
        features = "@target/failed.txt",
        glue = "projectFolders/uiAutomation/step_definitions"
)
public class FailedTestRunner {
}