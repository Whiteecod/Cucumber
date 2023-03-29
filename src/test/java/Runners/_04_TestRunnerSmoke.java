package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = "SmokeTest", // hangi senaryolarda bu
        features = {"src/test/java/FeatureFiles"},
        glue = {"StepDefinitions"}
)

        public class _04_TestRunnerSmoke extends AbstractTestNGCucumberTests {
}