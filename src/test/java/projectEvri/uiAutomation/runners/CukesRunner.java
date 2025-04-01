package projectEvri.uiAutomation.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                "rerun:target/failed.txt",
                "me.jvt.cucumber.report.PrettyReports:target"},
        features = "src/test/resources/uiFeatures",
        glue = "projectEvri/uiAutomation/step_definitions",
        dryRun = false,
        tags = "@ebay"
)
public class CukesRunner {
}
