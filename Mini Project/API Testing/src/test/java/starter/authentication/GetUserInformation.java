package starter.authentication;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class GetUserInformation {
    private static String url = "https://altashop-api.fly.dev/api/";

    @Step("I set valid API endpoint and method")
    public String setValidAPIEndpointAndMethod() {
        return url + "auth/info";
    }

    @Step("I send a request to get user information")
    public void sendRequestGetUserInformation() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6Iklyc3lhZCBBcmlmIiwiRW1haWwiOiJtaXJzeWFkYW5AbWFpbC5jb20ifQ.P5CAjpK8DRLU0H1SK_8zsgqSh6eIu4eIQvBKNWKp8CY";
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .get(setValidAPIEndpointAndMethod());
    }

    @Step("I receive status code 200 OK")
    public void receiveStatusCode200() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I get user information with valid")
    public void getUserInformation() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_USER_INFORMATION_SCHEMA);

        restAssuredThat(response -> response.body("'data'.'ID'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'Fullname'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'Email'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'Password'", notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    @Step("I set valid API endpoint and wrong method")
    public String setValidApiEndpointAndWrongMethod() {
        return url + "auth/info";
    }

    @Step("I send request to get user information with invalid method")
    public void sendReqGetUserInformationWithInvalidMethod() {
        SerenityRest.given()
                .patch(setValidApiEndpointAndWrongMethod());
    }

    @Step("I receive status code 405 method not allowed")
    public void receiveStatusCode405() {
        restAssuredThat(response -> response.statusCode(405));
    }
}
