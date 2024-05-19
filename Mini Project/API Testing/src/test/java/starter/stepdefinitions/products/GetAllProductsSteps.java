package starter.stepdefinitions.products;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.products.GetAllProducts;


public class GetAllProductsSteps {

    @Steps
    GetAllProducts getAllProducts;

    @Given("I set API endpoint and method with correctly")
    public void setApiEndpointAndMethodWithCorrectly(){
        getAllProducts.setApiEndpointAndMethodWithCorrectly();
    }
    @When("I send a request to get all products")
    public void sendRequestGetAllProducts(){
        getAllProducts.sendRequestGetAllProducts();
    }
    @Then("I receive the status code 200 OK")
    public void receiveTheStatusCode200(){
        getAllProducts.receiveTheStatusCode200();
    }
    @And("I get all products with valid")
    public void getAllProductsWithValid(){
        getAllProducts.getAllProductsWithValid();
    }
    @Given("I set the API endpoint and wrong method")
    public void setTheApiEndpointAndWrongMethod(){
        getAllProducts.setTheApiEndpointAndWrongMethod();
    }
    @When("I send request to get all products with invalid method")
    public void sendReqGetAllProductsWithInvalidMethod(){
        getAllProducts.sendReqGetAllProductsWithInvalidMethod();
    }
    @Then("I receive the status code 405 method not allowed")
    public void receiveTheStatusCode405(){
        getAllProducts.receiveTheStatusCode405();
    }
}
