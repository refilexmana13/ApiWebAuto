package com.refi.api.stepdef;

import com.refi.api.baseApi.baseApi;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

public class apiStepDef {

    baseApi api ;
    Response response;
    String name = "Shine Chena";
    int userId;


    @Given("I set POST api endpoint")
    public void iSetPOSTApiEndpoint() {
            api = new baseApi();
    }


    @When("I send POST HTTP request")
    public void iSendPOSTHTTPRequest() {
        response = api.postCreateUser(name, "chena" + System.currentTimeMillis() + "@mail.com", "male", "active");
        userId = response.jsonPath().getInt("id");
    }


    @Then("I receive valid HTTP response code {int}")
    public void iReceiveValidHTTPResponseCode(int code) {
        Assert.assertEquals(code, response.statusCode());
    }


    @And("I receive valid data for new user")
    public void iReceiveValidDataForNewUser() {
        String actualName = response.jsonPath().getString("name");
        Assert.assertEquals(name, actualName);
    }

    @Given("I set GET api endpoint")
    public void iSetGETApiEndpoint() {
        api = new baseApi();
    }


    @When("I send GET HTTP request")
    public void iSendGETHTTPRequest() {
        response = api.getUserById(userId);
    }
}
