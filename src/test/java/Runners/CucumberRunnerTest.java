package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/ToDoList.feature" },
        glue = {"tests/StepDefinition"},
        plugin = { "json:target/cucumber-json-report.json","html:target/site/cucumber-pretty"},
//        tags = "@ClearCompletedItem"
        tags = "@Create or @Edit or @CreateMultiple or @Complete or @RemoveIncompleteItem or @RemoveCompletedItem or @AllActiveCompleted or @ClearCompletedItem"
        )


public class CucumberRunnerTest extends AbstractTestNGCucumberTests {



}
