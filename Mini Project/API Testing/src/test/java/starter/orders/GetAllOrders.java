package starter.orders;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class GetAllOrders {
    private static String url = "https://altashop-api.fly.dev/api/";

    @Step("I set API endpoint and method with valid")
    public String setApiEndpointAndMethodWithValid() {
        return url + "orders";
    }

    @Step("I send a request to get all orders")
    public void sendRequestGetAllOrders() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6Iklyc3lhZCBBcmlmIiwiRW1haWwiOiJtaXJzeWFkYW5AbWFpbC5jb20ifQ.P5CAjpK8DRLU0H1SK_8zsgqSh6eIu4eIQvBKNWKp8CY";
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .get(setApiEndpointAndMethodWithValid());
    }

    @Step("I get status code 200 OK")
    public void getStatusCode200() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I get all orders with valid")
    public void getAllOrdersWithValid() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ALL_ORDERS_SCHEMA);

        restAssuredThat(response -> response.body("'data'.'Product'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'Price'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'Quantity'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'Subtotal'", notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    @Step("I set with valid API endpoint and wrong method")
    public String setWithValidApiEndpointAndWrongMethod() {
        return url + "orders";
    }

    @Step("I send request to get all orders with invalid method")
    public void sendReqGetAllOrdersWithInvalidMethod() {
        SerenityRest.given()
                .patch(setWithValidApiEndpointAndWrongMethod());
    }

    @Step("I get status code 405 method not allowed")
    public void getStatusCode405(){
        restAssuredThat(response -> response.statusCode(405));
    }
}
