package sampleProject.uiAutomation.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * This class serves as the entry point for running Cucumber tests.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                "rerun:target/failed.txt",
                "me.jvt.cucumber.report.PrettyReports:target",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
                
        features = "src/test/resources/uiFeatures",
        glue = "sampleProject/uiAutomation/step_definitions",
        dryRun = false,
        tags = "@evri"
)
public class CukesRunner {
}
