package pageObject;
import utilities.WaitUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;



public class HomePage {
	
	WebDriver driver;
	WaitUtils wu;

    // Constructor
    public HomePage(WebDriver driver) {

        this.driver = driver;
        wu= new WaitUtils(driver);
        PageFactory.initElements(driver, this);
        
    }

    // Locators

   

  
    // Action Methods

    public String getTitle() throws InterruptedException {
       wu.waitForTitleContains("EVSP - Charger Status");
       String title= driver.getTitle();
       System.out.println(title);
       return title;
    }

   

}
