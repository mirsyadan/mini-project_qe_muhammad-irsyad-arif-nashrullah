package starter.stepdefinitions.authencation;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.authentication.GetUserInformation;


public class GetUserInformationSteps {

    @Steps
    GetUserInformation getUserInformation;

    @Given("I set valid API endpoint and method")
    public void setValidAPIEndpointAndMethod(){
        getUserInformation.setValidAPIEndpointAndMethod();
    }
    @When("I send a request to get user information")
    public void sendRequestGetUserInformation(){
        getUserInformation.sendRequestGetUserInformation();
    }
    @Then("I receive status code 200 OK")
    public void receiveStatusCode200(){
        getUserInformation.receiveStatusCode200();
    }
    @And("I get user information with valid")
    public void getUserInformation(){
        getUserInformation.getUserInformation();
    }
    @Given("I set valid API endpoint and wrong method")
    public void setValidApiEndpointAndWrongMethod(){
        getUserInformation.setValidApiEndpointAndWrongMethod();
    }
    @When("I send request to get user information with invalid method")
    public void sendReqGetUserInformationWithInvalidMethod(){
        getUserInformation.sendReqGetUserInformationWithInvalidMethod();
    }
    @Then("I receive status code 405 method not allowed")
    public void receiveStatusCode405(){
        getUserInformation.receiveStatusCode405();
    }
}
