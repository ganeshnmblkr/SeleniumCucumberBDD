package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage extends BasePage {

   public  loginPage(WebDriver driver){
       super(driver);
       PageFactory.initElements( driver,this );
    }

    @FindBy(name="test")
    public WebElement login;


   public String validateLoginPageTitle(){
//       return this.driver.getTitle();
       return "Login Page:- "+driver.toString();
   }


}
