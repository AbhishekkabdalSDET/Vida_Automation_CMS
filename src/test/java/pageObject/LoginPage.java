package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    // Constructor
    public LoginPage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    // Locators

    @FindBy(xpath="//input[@id='LoginId']")
    WebElement txtUsername;

    @FindBy(xpath= "//input[@id='password-field']")
    WebElement txtPassword;

    @FindBy(xpath= "//input[@value='Sign In']")
    WebElement btnLogin;

    // Action Methods

    public void enterUsername(String username) {

        txtUsername.sendKeys(username);
    }

    public void enterPassword(String password) {

        txtPassword.sendKeys(password);
    }

    public void clickLogin() {

        btnLogin.click();
    }
}