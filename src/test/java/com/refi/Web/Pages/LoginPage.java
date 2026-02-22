package com.refi.Web.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;

    private final By inputTextUsername = By.cssSelector("input#user-name");
    private final By inputTextPassword = By.id("password");
    private final By buttonLogin = By.id("login-button");
    private final By errorMessage = By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3");

    //constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;

    }

    //method
    public void goToLoginPage() {
        driver.get("https://www.saucedemo.com/");
    }

    public void login(String username, String password) {
        driver.findElement(inputTextUsername).sendKeys(username);
        driver.findElement(inputTextPassword).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(buttonLogin).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}
