package starter.stepdefinitions.products;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.products.GetProductRatings;

public class GetProductRatingsSteps {

    @Steps
    GetProductRatings getProductRatings;

    @Given("I set with API endpoint and method")
    public void setWithApiEndpointAndMethod(){
        getProductRatings.setWithApiEndpointAndMethod();
    }
    @When("I send a request to get product ratings")
    public void sendRequestGetProductRatings(){
        getProductRatings.sendRequestGetProductRatings();
    }
    @Then("I receive is status code 200 OK")
    public void receiveIsStatusCode200(){
        getProductRatings.receiveIsStatusCode200();
    }
    @And("I get product ratings with valid")
    public void getProductRatingsWithValid(){
        getProductRatings.getProductRatingsWithValid();
    }
    @Given("I set API endpoint and wrong method")
    public void setApiEndpointAndWrongMethod(){
        getProductRatings.setApiEndpointAndWrongMethod();
    }
    @When("I send request to get product ratings with invalid method")
    public void sendReqProductRatingsWithInvalidMethod(){
        getProductRatings.sendReqProductRatingsWithInvalidMethod();
    }
    @Then("I receive is status code 405 method not allowed")
    public void receiveIsStatusCode405(){
        getProductRatings.receiveIsStatusCode405();
    }
}
