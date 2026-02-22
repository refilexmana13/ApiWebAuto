package com.refi.Web.StepDef;

import com.refi.Web.Base.BaseTest;
import com.refi.Web.Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginStepDef extends BaseTest {

    protected LoginPage loginPage;

    @Given("user is on login page")
    public void userIsOnLoginPage() {
        loginPage = new LoginPage(driver);
        loginPage.goToLoginPage();
    }

    @And("user input username and password text with {string} and {string}")
    public void userInputUsernameAndPasswordTextWithAnd(String username, String password) {
        loginPage.login(username, password);
    }

    @When("user click login button")
    public void userClickLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("user will be redirected to homepage")
    public void userWillBeRedirectedToHomepage() {

    }

    @Then("user will see error message {string}")
    public void userWillSeeErrorMessage(String errorMessage) {
        String actualErrorMessage = loginPage.getErrorMessage();
        assert actualErrorMessage.equals(errorMessage) : "Expected error message: " + errorMessage + ", but got: " + actualErrorMessage;
    }
}
