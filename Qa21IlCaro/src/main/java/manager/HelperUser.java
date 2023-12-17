package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelperUser extends HelperBase{
    public HelperUser(WebDriver wd) {
        super(wd);
    }
    public void openLogRegForm(){
        WebElement logform= wd.findElement(By.xpath("//a[@class='navigation-link'][5]"));
        logform.click();
    }
    public void typeLogPass(String email, String password){
        type(By.id("email"),email);
        type(By.id("password"),password);
        click(By.cssSelector("button[type='submit']"));
        click(By.cssSelector("button[type='button']"));
    }
}
