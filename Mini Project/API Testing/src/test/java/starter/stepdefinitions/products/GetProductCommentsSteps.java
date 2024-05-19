package starter.stepdefinitions.products;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.products.GetProductComments;

public class GetProductCommentsSteps {

    @Steps
    GetProductComments getProductComments;

    @Given("I set API endpoint and method")
    public void setApiEndpointAndMethod(){
        getProductComments.setApiEndpointAndMethod();
    }
    @When("I send a request to get product comments")
    public void sendRequestGetProductComments(){
        getProductComments.sendRequestGetProductComments();
    }
    @Then("I receive on status code 200 OK")
    public void receiveOnStatusCode200(){
        getProductComments.receiveOnStatusCode200();
    }
    @And("I get product comments with valid")
    public void getProductCommentsWithValid(){
        getProductComments.getProductCommentsWithValid();
    }
    @Given("I set a API endpoint and wrong method")
    public void setAApiEndpointAndWrongMethod(){
        getProductComments.setAApiEndpointAndWrongMethod();
    }
    @When("I send request to get product comments with invalid method")
    public void sendReqProductCommentsWithInvalidMethod(){
        getProductComments.sendReqProductCommentsWithInvalidMethod();
    }
    @Then("I receive on status code 405 method not allowed")
    public void receiveOnStatusCode405(){
        getProductComments.receiveOnStatusCode405();
    }
}
