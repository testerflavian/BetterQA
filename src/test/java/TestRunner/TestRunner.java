package TestRunner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"Features"},

        glue = {"Steps"},

        plugin = {"pretty", "html:reports/reports.html"},

        dryRun = false,
        monochrome = true,
        tags = "@S5"
)
public class TestRunner {}
