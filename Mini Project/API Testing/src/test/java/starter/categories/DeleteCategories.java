package starter.categories;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class DeleteCategories {
    private static String url = "https://altashop-api.fly.dev/api/";

    @Step("I set valid endpoint and method")
    public String setValidEndpointAndMethod() {
        return url + "categories/1";
    }

    @Step("I send a request to delete a categories")
    public void sendRequestDeleteCategories() {
        SerenityRest.given()
                .delete(setValidEndpointAndMethod());
    }

    @Step("I receive in status code 200 OK")
    public void receiveInStatusCode200() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I see categories has delete with valid")
    public void seeCategoriesHasDeleteWithValid() {
    }

    @Step("I set valid endpoint and wrong method")
    public String setValidEndpointAndWrongMethod() {
        return url + "categories/1";
    }

    @Step("I send request to delete a categories with invalid method")
    public void sendReqDeleteCategoriesWithInvalidMethod() {
        SerenityRest.given()
                .patch(setValidEndpointAndWrongMethod());
    }

    @Step("I receive in status code 405 method not allowed")
    public void receiveInStatusCode405(){
        restAssuredThat(response -> response.statusCode(405));
    }
}
