package pages;

import TestBase.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends  BasePage{

    public HomePage( WebDriver driver ){
        super(driver);
        PageFactory.initElements( driver,this );
    }

    @FindBy(xpath = "//section/p")
    public WebElement HomePageElement;

    public String verifyUserIsOnHomePage(){
        return DriverHelper.readTextFromElement( driver,HomePageElement );
    }
}

