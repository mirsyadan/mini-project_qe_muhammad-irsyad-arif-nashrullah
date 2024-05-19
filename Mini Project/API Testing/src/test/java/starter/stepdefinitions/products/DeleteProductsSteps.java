package starter.stepdefinitions.products;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.products.DeleteProducts;

public class DeleteProductsSteps {

    @Steps
    DeleteProducts deleteProduct;

    @Given("I set endpoint and method with valid")
    public void setEndpointAndMethodWithValid(){
        deleteProduct.setEndpointAndMethodWithValid();
    }
    @When("I send a request to delete a product")
    public void sendRequestDeleteProduct(){
        deleteProduct.sendRequestDeleteProduct();
    }
    @Then("I get a status code 200 OK")
    public void getAStatusCode200(){
        deleteProduct.getAStatusCode200();
    }
    @And("I see product has delete with valid")
    public void seeProductHasDeleteWithValid(){
        deleteProduct.seeProductHasDeleteWithValid();
    }
    @Given("I set with valid endpoint and wrong method")
    public void setWithValidEndpointWrongMethod(){
        deleteProduct.setWithValidEndpointWrongMethod();
    }
    @When("I send request to delete a product with invalid method")
    public void sendReqDeleteProductWithInvalidMethod(){
        deleteProduct.sendReqDeleteProductWithInvalidMethod();
    }
    @Then("I get a status code 405 method not allowed")
    public void getAStatusCode405(){
        deleteProduct.getAStatusCode405();
    }
}
