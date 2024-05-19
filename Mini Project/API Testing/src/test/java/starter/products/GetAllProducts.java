package starter.products;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class GetAllProducts {
    private static String url = "https://altashop-api.fly.dev/api/";

    @Step("I set API endpoint and method with correctly")
    public String setApiEndpointAndMethodWithCorrectly() {
        return url + "products";
    }

    @Step("I send a request to get all products")
    public void sendRequestGetAllProducts() {
        SerenityRest.given()
                .get(setApiEndpointAndMethodWithCorrectly());
    }

    @Step("I receive the status code 200 OK")
    public void receiveTheStatusCode200() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I get all products with valid")
    public void getAllProductsWithValid() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ALL_PRODUCTS_SCHEMA);

        restAssuredThat(response -> response.body("'data'.'ID'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'Name'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'Description'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'Price'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'Ratings'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'Categories'", notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    //NEGATIVE
    @Step("I set the API endpoint and wrong method")
    public String setTheApiEndpointAndWrongMethod() {
        return url + "products";
    }

    @Step("I send request to get all products with invalid method")
    public void sendReqGetAllProductsWithInvalidMethod() {
        SerenityRest.given()
                .patch(setTheApiEndpointAndWrongMethod());
    }

    @Step("I receive the status code 405 method not allowed")
    public void receiveTheStatusCode405(){
        restAssuredThat(response -> response.statusCode(405));
    }
}