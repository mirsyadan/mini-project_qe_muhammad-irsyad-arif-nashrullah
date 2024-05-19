package starter.categories;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class GetAllCategories {
    private static String url = "https://altashop-api.fly.dev/api/";

    @Step("I set with valid API endpoint and method")
    public String setWithValidApiEndpointAndMethod() {
        return url + "categories";
    }

    @Step("I send a request to get all categories")
    public void sendRequestGetAllCategories() {
        SerenityRest.given()
                .get(setWithValidApiEndpointAndMethod());
    }

    @Step("I receive a status code 200 OK")
    public void receiveAStatusCode200() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I get all categories with valid")
    public void getAllCategoriesWithValid() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ALL_CATEGORIES_SCHEMA);

        restAssuredThat(response -> response.body("'data'.'ID'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'Name'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'Description'", notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    @Step("I set with API endpoint and wrong method")
    public String setWithApiEndpointAndWrongMethod() {
        return url + "categories";
    }

    @Step("I send request to get all categories with invalid method")
    public void sendReqGetAllCategoriesWithInvalidMethod() {
        SerenityRest.given()
                .patch(setWithApiEndpointAndWrongMethod());
    }

    @Step("I receive a status code 405 method not allowed")
    public void receiveAStatusCode405(){
        restAssuredThat(response -> response.statusCode(405));
    }
}
