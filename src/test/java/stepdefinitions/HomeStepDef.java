package stepdefinitions;

import base.DateTimeArticle;
import base.WebApp;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.LoginPage;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomeStepDef {
    LoginPage loginPage = new LoginPage();

    @Given("I open Login Page")
    public void iOpenHomePage() {
        System.out.println("I open Login Page");
        loginPage.iOpenLoginPage();

    }

    @When("Input user name: {} and password: {}")
    public void inputUserNamePassword(String userName, String password) {
        System.out.println("Input user name and password");
        loginPage.inputUserNameAndPass(userName, password);
    }

}
