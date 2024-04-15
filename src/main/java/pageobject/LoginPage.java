package pageobject;

import base.DateTimeArticle;
import base.WebApp;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class LoginPage {

    WebApp app = WebApp.getWebApp();
    private static final By LIST_ARTICLE_IN_A_PAGE = By.xpath("//div[@id = 'content']/article");

    private static final By TIME_OF_ARTICLE(int index) {

        return By.xpath("//div[@id = 'content']/article[" + index + "]//time");
    }

    private static final By CHUYEN_CODING_IN_MENU_BAR = By.xpath("//li[@id='menu-item-12']");
    private static final By BAO_MAT_NHAP_MON_IN_CHUYEN_CODING = By.xpath("//li[@id='menu-item-3739']");

    public void iOpenHomePage() {
        // System.out.println("I open Home Page");
        app.getDriver().get("https://toidicodedao.com/");
    }

    public String[] iSeePostTenLastMostRecent() {
        // List<WebElement> listArticle = app.listElement(LIST_ARTICLE_IN_A_PAGE);

        String dateList[] = new String[app.sizeOfListElement(LIST_ARTICLE_IN_A_PAGE)];
        for (int i = 1; i <= app.sizeOfListElement(LIST_ARTICLE_IN_A_PAGE); i++) {
            dateList[i-1] = app.getText(TIME_OF_ARTICLE(i)).trim();
        }
        return dateList;
    }

    public void iHoverChuyenCodingOnMenuBar() {
        app.hover(CHUYEN_CODING_IN_MENU_BAR);

    }

    public void iHoverAndClickSeriesBaoMatNhapMon() {
        app.hoverAndClick(BAO_MAT_NHAP_MON_IN_CHUYEN_CODING);

    }

    public void seriesBaoMatNhapMonPageOpenInANewTab() {
        // windows handling
        // System.out.println(app.getDriver().getCurrentUrl());
        for(String winHandle : app.getDriver().getWindowHandles()){
            app.getDriver().switchTo().window(winHandle);
        }
        // System.out.println(app.getDriver().getCurrentUrl());
    }

}
