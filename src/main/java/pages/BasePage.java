package pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver driver;
//    HomePage homePage;
    public BasePage(WebDriver driver){
        this.driver=driver;
//        homePage=new HomePage( driver );
    }
}
