package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
(
		features="C:\\Users\\Home\\ActiTimeBDDframe\\src\\main\\java\\Features\\HomePage.feature",
		glue= {"StepDefinition"}
		,dryRun= false,
		monochrome=true
)
public class TestRunner {

}
