package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

    WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public WaitUtils(WebDriver driver) {

        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Wait for visibility of WebElement
    public WebElement waitForVisibility(WebElement element) {

        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Wait for visibility using By locator
    public WebElement waitForVisibility(By locator) {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Wait for clickable
    public WebElement waitForClickable(WebElement element) {

        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    // Wait for presence
    public WebElement waitForPresence(By locator) {

        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    // Wait for invisibility
    public boolean waitForInvisibility(WebElement element) {

        return wait.until(ExpectedConditions.invisibilityOf(element));
    }

    // Wait for title contains
    public boolean waitForTitleContains(String title) {

        return wait.until(ExpectedConditions.titleContains(title));
    }

    // Wait for exact title
    public boolean waitForTitleIs(String title) {

        return wait.until(ExpectedConditions.titleIs(title));
    }

    // Wait for URL contains
    public boolean waitForUrlContains(String url) {

        return wait.until(ExpectedConditions.urlContains(url));
    }

    // Wait for alert
    public void waitForAlert() {

        wait.until(ExpectedConditions.alertIsPresent());
    }

    // Wait for frame and switch
    public void waitForFrame(String frameName) {

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameName));
    }

    // Wait for text in element
    public boolean waitForText(WebElement element, String text) {

        return wait.until(
                ExpectedConditions.textToBePresentInElement(element, text));
    }
}