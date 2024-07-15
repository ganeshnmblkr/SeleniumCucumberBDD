package pages;

import TestBase.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage extends BasePage {

   public  loginPage(WebDriver driver){
       super(driver);
       PageFactory.initElements( driver,this );
    }


    @FindBy(xpath="//a[@href=\"http://qaclickacademy.usefedora.com/sign_in\"]")
    public WebElement HomePageloginButton;

//    @FindBy(xpath="//input[@id=\"email\"]")
    @FindBy(id="userEmail")
    public WebElement userID;

//    @FindBy(xpath="//input[@id=\"password\"]")
    @FindBy(id="userPassword")
    public WebElement userPassword;

//    @FindBy(xpath="//input[@type=\"submit\"]")
    @FindBy(id="login")
    public WebElement loginButton;


    public String validateLoginPageTitle(String strUserID,String password){
//        DriverHelper.click( driver,HomePageloginButton);
        DriverHelper.clearAndSendKeys( driver,userID,strUserID );
        DriverHelper.clearAndSendKeys( driver,userPassword,password );
        DriverHelper.click( driver,loginButton);
//        DriverHelper.readTextFromElement( driver, homePage.HomePageElement)
        return driver.getTitle();
   }


}
