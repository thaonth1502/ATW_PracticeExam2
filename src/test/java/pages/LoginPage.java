package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    private String password = BaseTest.ini_password;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    By inputUserName = By.xpath("//input[@name='uid']");
    By inputPassword = By.xpath("//input[@name='password']");
    By btn_Login = By.xpath("//input[@name='btnLogin']");

    public void inputUserName(String username){
        this.driver.findElement(this.inputUserName).sendKeys(username);
    }

    public void inputPassword(String password){
        this.driver.findElement(this.inputPassword).sendKeys(password);
    }

    public void clickLoginButton(){
        this.driver.findElement(this.btn_Login).click();
    }
}
