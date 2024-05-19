package starter.products;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class GetProductRatings {
    private static String url = "https://altashop-api.fly.dev/api/";

    @Step("I set with API endpoint and method")
    public String setWithApiEndpointAndMethod() {
        return url + "products/1/ratings";
    }

    @Step("I send a request to get product ratings")
    public void sendRequestGetProductRatings() {
        SerenityRest.given()
                .get(setWithApiEndpointAndMethod());
    }

    @Step("I receive is status code 200 OK")
    public void receiveIsStatusCode200() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I get product ratings with valid")
    public void getProductRatingsWithValid() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_PRODUCT_RATINGS_SCHEMA);

        restAssuredThat(response -> response.body("'data'", notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    @Step("I set API endpoint and wrong method")
    public String setApiEndpointAndWrongMethod() {
        return url + "products/1/ratings";
    }

    @Step("I send request to get product ratings with invalid method")
    public void sendReqProductRatingsWithInvalidMethod() {
        SerenityRest.given()
                .patch(setApiEndpointAndWrongMethod());
    }

    @Step("I receive is status code 405 method not allowed")
    public void receiveIsStatusCode405(){
        restAssuredThat(response -> response.statusCode(405));
    }
}
