package starter.stepdefinitions.categories;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.categories.DeleteCategories;

public class DeleteCategoriesSteps {

    @Steps
    DeleteCategories deleteCategories;

    @Given("I set valid endpoint and method")
    public void setValidEndpointAndMethod(){
        deleteCategories.setValidEndpointAndMethod();
    }
    @When("I send a request to delete a categories")
    public void sendRequestDeleteCategories(){
        deleteCategories.sendRequestDeleteCategories();
    }
    @Then("I receive in status code 200 OK")
    public void receiveInStatusCode200(){
        deleteCategories.receiveInStatusCode200();
    }
    @And("I see categories has delete with valid")
    public void seeCategoriesHasDeleteWithValid(){
        deleteCategories.seeCategoriesHasDeleteWithValid();
    }
    @Given("I set valid endpoint and wrong method")
    public void setValidEndpointAndWrongMethod(){
        deleteCategories.setValidEndpointAndWrongMethod();
    }
    @When("I send request to delete a categories with invalid method")
    public void sendReqDeleteCategoriesWithInvalidMethod(){
        deleteCategories.sendReqDeleteCategoriesWithInvalidMethod();
    }
    @Then("I receive in status code 405 method not allowed")
    public void receiveInStatusCode405(){
        deleteCategories.receiveInStatusCode405();
    }
}
