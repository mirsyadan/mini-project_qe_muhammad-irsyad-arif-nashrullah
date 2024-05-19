package starter.stepdefinitions.orders;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.orders.GetAllOrders;


public class GetAllOrdersSteps {

    @Steps
    GetAllOrders getAllOrders;

    @Given("I set API endpoint and method with valid")
    public void setApiEndpointAndMethodWithValid(){
        getAllOrders.setApiEndpointAndMethodWithValid();
    }
    @When("I send a request to get all orders")
    public void sendRequestGetAllOrders(){
        getAllOrders.sendRequestGetAllOrders();
    }
    @Then("I get status code 200 OK")
    public void getStatusCode200(){
        getAllOrders.getStatusCode200();
    }
    @And("I get all orders with valid")
    public void getAllOrdersWithValid(){
        getAllOrders.getAllOrdersWithValid();
    }
    @Given("I set with valid API endpoint and wrong method")
    public void setWithValidApiEndpointAndWrongMethod(){
        getAllOrders.setWithValidApiEndpointAndWrongMethod();
    }
    @When("I send request to get all orders with invalid method")
    public void sendReqGetAllOrdersWithInvalidMethod(){
        getAllOrders.sendReqGetAllOrdersWithInvalidMethod();
    }
    @Then("I get status code 405 method not allowed")
    public void getStatusCode405(){
        getAllOrders.getStatusCode405();
    }
}
