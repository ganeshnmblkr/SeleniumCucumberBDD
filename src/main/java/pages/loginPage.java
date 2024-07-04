package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage {
    private WebDriver driver;

    loginPage(WebDriver driver){
        this.driver=driver;
    }

    @FindBy(name="test")
    public WebElement login;



}
