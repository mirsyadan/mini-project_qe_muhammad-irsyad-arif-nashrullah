package starter.products;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class DeleteProducts {
    private static String url = "https://altashop-api.fly.dev/api/";

    @Step("I set endpoint and method with valid")
    public String setEndpointAndMethodWithValid() {
        return url + "products/1";
    }

    @Step("I send a request to delete a product")
    public void sendRequestDeleteProduct() {
        SerenityRest.given()
                .delete(setEndpointAndMethodWithValid());
    }

    @Step("I get a status code 200 OK")
    public void getAStatusCode200() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I see product has delete with valid")
    public void seeProductHasDeleteWithValid() {
    }

    @Step("I set with valid endpoint and wrong method")
    public String setWithValidEndpointWrongMethod() {
        return url + "products/1";
    }

    @Step("I send request to delete a product with invalid method")
    public void sendReqDeleteProductWithInvalidMethod() {
        SerenityRest.given()
                .patch(setWithValidEndpointWrongMethod());
    }
    @Step("I get a status code 405 method not allowed")
    public void getAStatusCode405(){
        restAssuredThat(response -> response.statusCode(405));
    }
}
