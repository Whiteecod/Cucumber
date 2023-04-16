package StepDefinitions;

import Pages.DialogContent;
import Utilities.ExcelUtility;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.ArrayList;

public class _10_ApachePOISteps {
    DialogContent dc = new DialogContent();
    @When("User Create citizenship with ApachePOI")
    public void userCreateCitizenshipWithApachePOI() throws IOException {
       ArrayList< ArrayList<String> > tablo = ExcelUtility.getData
               ("src/test/java/ApachePOI/resource/ApacheExcel2.xlsx","testCitizen",2);

       for (ArrayList<String> satir : tablo) {
           dc.clickFunction(dc.addButton);
           dc.sendKeysFunction(dc.nameInput, satir.get(0));
           dc.sendKeysFunction(dc.shortName, satir.get(1));
           dc.clickFunction(dc.saveButton);
           dc.verifyContainsTextFunction(dc.successMessage,"success");
       }
    }

    @Then("User Delete citizenship with ApachePOI")
    public void userDeleteCitizenshipWithApechePOI() throws IOException {
        ArrayList< ArrayList<String> > tablo = ExcelUtility.getData
                ("src/test/java/ApachePOI/resource/ApacheExcel2.xlsx","testCitizen",2);

        for (ArrayList<String> satir : tablo) {
            dc.deleteItem(satir.get(0));
            dc.verifyContainsTextFunction(dc.successMessage, "success");
        }
    }
}
