package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
// there should be usually one test runner per feature.
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "./src/test/resources/features",
        glue = "step_definitions",
        dryRun = false,
        tags = "@DemoQADatePicker",
        plugin = {"pretty", "html:Reports/htmlReport.html", "json:Reports/jsonReport.json"}

)

public class DemoQARunner {


}
