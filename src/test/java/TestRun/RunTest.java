package TestRun;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions

	(
	features= {".//Features/login.feature"},
	glue= {"Stepdefnition","Hooks"},
	dryRun=false,
	monochrome=true,
	plugin= {"pretty","html:test-output.html"}
		)

public class RunTest {
	
}
