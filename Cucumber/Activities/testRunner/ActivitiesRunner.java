package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/Features",
    glue = {"stepDefinition"},
    tags = "@activity1_1 or @activity1_2 or @activity1_3 or @activity2_4 or @activity2_5",
    //tags = "@SmokeTest",  //tag for activity6
    plugin = {"pretty"},
    //plugin = {"json: test-reports/json-report.json"},
    monochrome = true
)

public class ActivitiesRunner {

}
