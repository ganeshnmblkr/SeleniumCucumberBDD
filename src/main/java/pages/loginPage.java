package pages;

import TestBase.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.sql.Driver;

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

    @FindBy(xpath ="//button[@class=\"btn btn-custom\" and contains(text(),\" Sign Out \")]")
    public WebElement logoutButton;


    public void validateLoginPageTitle(String strUserID,String password){
        DriverHelper.clearAndSendKeys( driver,userID,strUserID );
        DriverHelper.clearAndSendKeys( driver,userPassword,password );
        DriverHelper.click( driver,loginButton);
        System.out.println("user logs in successfully ");
   }

   public void signOutFromPortal(){
       DriverHelper.click( driver,logoutButton);
   }

}
