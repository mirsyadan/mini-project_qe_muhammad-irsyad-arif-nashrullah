package starter.products;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class GetProductComments {
    private static String url = "https://altashop-api.fly.dev/api/";

    @Step("I set API endpoint and method")
    public String setApiEndpointAndMethod() {
        return url + "products/2/comments";
    }

    @Step("I send a request to get product comments")
    public void sendRequestGetProductComments() {
        SerenityRest.given()
                .get(setApiEndpointAndMethod());
    }

    @Step("I receive on status code 200 OK")
    public void receiveOnStatusCode200() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I get product comments with valid")
    public void getProductCommentsWithValid() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_PRODUCT_COMMENTS_SCHEMA);

        restAssuredThat(response -> response.body("'data'.'ID'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'Content'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'User'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'Product'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'Comment'", notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    @Step("I set a API endpoint and wrong method")
    public String setAApiEndpointAndWrongMethod() {
        return url + "products/2/comments";
    }

    @Step("I send request to get product comments with invalid method")
    public void sendReqProductCommentsWithInvalidMethod() {
        SerenityRest.given()
                .patch(setAApiEndpointAndWrongMethod());
    }

    @Step("I receive on status code 405 method not allowed")
    public void receiveOnStatusCode405(){
        restAssuredThat(response -> response.statusCode(405));
    }
}
