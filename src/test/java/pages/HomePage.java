package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class HomePage {
    WebDriver driver;
    Actions actions;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(this.driver);
    }

    By titlePage = By.xpath("//h2[normalize-space()='Guru99 Bank']");
    By mangerID = By.xpath("//td[contains(text(),'"+ BaseTest.ini_username+"')]");
    By menuChangePassword = By.xpath("//a[normalize-space()='Change Password']");
    By menuLogout = By.xpath("//a[normalize-space()='Log out']");
    By menuNewCustomer = By.xpath("//a[normalize-space()='New Customer']");

    public void clickMenuNewCustomer(){
        WebElement newCustomerMenu = this.driver.findElement(this.menuNewCustomer);
        actions.moveToElement(newCustomerMenu).build().perform();
        newCustomerMenu.click();
    }

    public void verifyLogoutSuccess(){
        String expectedMessage = "You Have Succesfully Logged Out!!";
        String actualMessage = this.driver.switchTo().alert().getText();
        Assert.assertEquals(expectedMessage,actualMessage);
        this.driver.switchTo().alert().accept();
    }

    public void clickMenuLogout(){
        WebElement logoutMenu = this.driver.findElement(this.menuLogout);
        actions.moveToElement(logoutMenu).build().perform();
        logoutMenu.click();
    }

    public void clickMenuChangePassword(){
        WebElement changePasswordMenu = this.driver.findElement(this.menuChangePassword);
        actions.moveToElement(changePasswordMenu).build().perform();
        changePasswordMenu.click();
    }

    public void verifyHomePage(){
        System.out.println("//td[contains(text(),'"+ BaseTest.ini_username+"')]");
        this.driver.findElement(this.titlePage).isDisplayed();
        this.driver.findElement(this.mangerID).isDisplayed();
        Assert.assertEquals(this.driver.findElement(this.titlePage).getText(),"Guru99 Bank");
        assert this.driver.findElement(this.mangerID).getText().contains(BaseTest.ini_username);
    }
}
