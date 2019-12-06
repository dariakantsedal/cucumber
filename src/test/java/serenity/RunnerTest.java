package serenity;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
@RunWith (CucumberWithSerenity.class)
@CucumberOptions(
        glue={"org.serenity"}, 
        features="src/test/resources/squash/serenity",
        plugin = {"de.monochromata.cucumber.report.PrettyReports:target/cucumber"}, 
        monochrome = true
)
public class RunnerTest {

}
