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
    DateTimeArticle dateTimeArticle = new DateTimeArticle();

    @Given("I open Home Page")
    public void iOpenHomePage() {
        System.out.println("I open Home Page");
        loginPage.iOpenHomePage();

    }

    @Then("I see ten posts last most recent")
    public void iSeeTenPostLastMostRecent() {
        String[] dateList = loginPage.iSeePostTenLastMostRecent();
        for (int i = 0; i < dateList.length - 1; i++) {
            Assert.assertEquals("Not correctly",
                    dateTimeArticle.compareDate(dateList[i], loginPage.iSeePostTenLastMostRecent()[i + 1]), false);
        }

    }

    @When("I hover Chuyen Coding on menu bar")
    public void iHoverChuyenCodingOnMenuBar() {
        System.out.println("I hover Chuyen Coding on menu bar");
        loginPage.iHoverChuyenCodingOnMenuBar();
    }

    @And("I hover and click Series bao mat nhap mon")
    public void iHoverAndClickSeriesBaoMatNhapMon() {
        System.out.println("I hover and click Series bao mat nhap mon");
        loginPage.iHoverAndClickSeriesBaoMatNhapMon();

    }

    @Then("Series bao mat nhap mon page open in a new tab")
    public void seriesBaoMatNhapMonPageOpenInANewTab() {
        System.out.println("Series bao mat nhap mon page open in a new tab");
        loginPage.seriesBaoMatNhapMonPageOpenInANewTab();

    }

    @When("I click December 2020 in Luu Tru")
    public void iClickDecember2020InLuuTru() {
       

    }

    @Then("I see post in December 2020")
    public void iSeePostInDecember2020() {
        

    }

    @And("Link Continue Reading is displayed in each post")
    public void LinkContinueReadingIsDisplayedInEachPost() {
        
    }

}
