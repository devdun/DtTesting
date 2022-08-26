package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/firstTest.feature" },
        glue = {"tests/StepDefinition"}
        )


public class CucumberRunnerTest extends AbstractTestNGCucumberTests {



}
