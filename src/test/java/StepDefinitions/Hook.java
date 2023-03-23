package StepDefinitions;

import Utilities.GWD;
import io.cucumber.java.After;
import org.testng.annotations.AfterGroups;

public class Hook {

    @After
    public void after() {
        System.out.println("Senaryo Bitti");
        GWD.quitDriver();
    }
}
