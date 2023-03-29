package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = "@Regression or @SmokeTest" ,// hangi senaryolarda bu etiket varsa onları çalıştırır
        // or yerine and yazılır ise hem smoke hemde regression tag i olanları çalıştırır
        features = {"src/test/java/FeatureFiles"},
        glue = {"StepDefinitions"}
)

public class _05_TestRunnerRegression extends AbstractTestNGCucumberTests {
}
