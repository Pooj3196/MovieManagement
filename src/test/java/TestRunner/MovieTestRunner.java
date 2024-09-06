package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features", 
        glue = {"StepDefinations"}, 
        plugin = {
                "pretty", 
                "html:target/cucumber-reports/cucumber.html", 
                "json:target/cucumber-reports/cucumber.json" 
        },
        monochrome = true 
)
public class MovieTestRunner {
	
}