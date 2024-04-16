package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class WebApp {
    WebDriver driver;

    public static ThreadLocal<WebApp> tlWebApp = new ThreadLocal<>();

    public WebApp() {
        getDriver();
    }

    public static WebApp getWebApp() {
        return tlWebApp.get();
    }

    public static void setWebApp(WebApp app) {
        tlWebApp.set(app);
    }

    public WebDriver getDriver() {
        System.out.println("====================================");
        if (driver == null) {
            System.out.println("Starting Chrome");
//            WebDriverManager.chromedriver().clearDriverCache();
//            WebDriverManager.chromedriver().setup();
//            ChromeOptions chromeOptions = new ChromeOptions();
//            chromeOptions.addArguments("--allow-running-insecure-content");
//            chromeOptions.addArguments("--ignore-certificate-errors");
//            chromeOptions.addArguments("--disable-web-security");
//            chromeOptions.addArguments("disable-infobars");
//            chromeOptions.addArguments("window-size=800,600");
//            driver = new ChromeDriver(chromeOptions);
//            driver = new ChromeDriver();

            WebDriverManager.firefoxdriver().clearDriverCache();
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        return driver;
    }

    public void click(By locator) {
        try {
            System.out.println("Clicking on " + locator.toString());
            fluentWaitForElement(locator).click();
        } catch (Exception exception) {
            throw exception;
        }
    }

    public void input(By locator, String data) {
        try {
            System.out.println("Input " + locator.toString());
            fluentWaitForElement(locator).click();
            fluentWaitForElement(locator).sendKeys(data);
        } catch (Exception exception) {
            throw exception;
        }
    }

    public void hover(By by) {
        try {
            System.out.println("Hover " + by.toString());
            Actions action = new Actions(driver);
            action.moveToElement(fluentWaitForElement(by)).perform();
        } catch (Exception e) {
            throw e;
        }
    }

    public void hoverAndClick(By by) {
        try {
            System.out.println("Hover & click " + by.toString());
            Actions action = new Actions(driver);
            WebElement hoverClickElem = fluentWaitForElement(by);
            action.moveToElement(hoverClickElem).click(hoverClickElem)
                    .build().perform();
        } catch (Exception e) {
            throw e;
        }
    }

    public List<WebElement> listElement(By by) {
        try {
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            return driver.findElements(by);
        } catch (Exception exception) {
            throw exception;
        }
    }

    public int sizeOfListElement(By by) {
        try {
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            return driver.findElements(by).size();

        } catch (Exception exception) {
            throw exception;
        }
    }

    public WebElement explicitWaitForElement(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 20);
            return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Exception exception) {
            throw exception;
        }
    }


    public WebElement fluentWaitForElement(By by) {
        try {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(60))
                    .pollingEvery(Duration.ofMillis(500))
                    .ignoring(NoSuchElementException.class);
            WebElement element = wait.until(new Function<WebDriver, WebElement>() {
                public WebElement apply(WebDriver driver) {
                    WebElement e = driver.findElement(by);
                    if (!e.isDisplayed())
                        throw new NoSuchElementException("");
                    return e;
                }
            });
            return element;
        } catch (Exception exception) {
            throw exception;
        }
    }

    public boolean isElementDisplayed(By by) {
        try {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            WebElement element = driver.findElement(by);
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        } finally {
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        }
    }


    public void quit() {
        if (driver != null) {
            System.out.println("Closing Chrome");
            driver.close();
            driver.quit();
        }
    }

    public String getText(By locator) {
        try {
            if (isElementDisplayed(locator)) {
                fluentWaitForElement(locator).getText().trim();
                // System.out.println(" Get text " + fluentWaitForElement(locator).getText().trim());

            }
            return fluentWaitForElement(locator).getText().trim();
        } catch (Exception exception) {
            throw exception;
        }

    }

    public void Back() {
        driver.navigate().back();
    }
}

