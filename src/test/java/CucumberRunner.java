
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/functionalTests",
		glue= {"stepDefinitions"}
		)
public class CucumberRunner {

}
