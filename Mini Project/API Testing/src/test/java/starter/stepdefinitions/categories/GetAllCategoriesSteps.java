package starter.stepdefinitions.categories;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.categories.GetAllCategories;


public class GetAllCategoriesSteps {

    @Steps
    GetAllCategories getAllCategories;

    @Given("I set with valid API endpoint and method")
    public void setWithValidApiEndpointAndMethod(){
        getAllCategories.setWithValidApiEndpointAndMethod();
    }
    @When("I send a request to get all categories")
    public void sendRequestGetAllCategories(){
        getAllCategories.sendRequestGetAllCategories();
    }
    @Then("I receive a status code 200 OK")
    public void receiveAStatusCode200(){
        getAllCategories.receiveAStatusCode200();
    }
    @And("I get all categories with valid")
    public void getAllCategoriesWithValid(){
        getAllCategories.getAllCategoriesWithValid();
    }
    @Given("I set with API endpoint and wrong method")
    public void setWithApiEndpointAndWrongMethod(){
        getAllCategories.setWithApiEndpointAndWrongMethod();
    }
    @When("I send request to get all categories with invalid method")
    public void sendReqGetAllCategoriesWithInvalidMethod(){
        getAllCategories.sendReqGetAllCategoriesWithInvalidMethod();
    }
    @Then("I receive a status code 405 method not allowed")
    public void receiveAStatusCode405(){
        getAllCategories.receiveAStatusCode405();
    }
}
