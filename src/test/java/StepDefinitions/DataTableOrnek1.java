package StepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import java.util.List;

public class DataTableOrnek1 {
    @When("Write username {string}")
    public void writeUsername(String userName) {
        System.out.println("userName = " + userName);

    }

    @And("Write username and Password {string} and {string}")
    public void writeUsernameAndPassword(String userName, String password) {
        System.out.println("userName and pass =" + userName + " " + password);
    }


    @And("Write username as DataTable")
    public void writeUsernameAsDataTable(DataTable items) {
        List<String> allItems = items.asList(String.class);
        for (String u: allItems)
            System.out.println(u);
    }

    @And("Write username and password as DataTable")
    public void writeUsernameAndPasswordAsDataTable(DataTable items) {
        List < List<String> > allItemsAndPassword = items.asLists(String.class);

        for (int i = 0; i <allItemsAndPassword.size() ; i++) {
            System.out.println("allItemsAndPassword = " + allItemsAndPassword.get(i).get(0) +
                    " " + allItemsAndPassword.get(i).get(1));
        }
    }
}
