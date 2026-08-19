
package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import testbases.BaseClass;

public class TC01_LoginTest extends BaseClass {

	
    @Test
    public void verifyLogin() throws InterruptedException {

        LoginPage lp = new LoginPage(driver);

        lp.enterUsername("Abhishek");

        lp.enterPassword("Kabdwal@123");

        lp.clickLogin();
        
        HomePage hp= new HomePage(driver);
        String actual=hp.getTitle();
        Assert.assertEquals("A", "B");
        Assert.assertEquals(actual, "EVSP - Charger Status");
        
        
  // Completed basic test
       
    }
}