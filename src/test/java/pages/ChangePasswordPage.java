package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class ChangePasswordPage {

    WebDriver driver;
    Actions actions;
    LoginPage loginPage = new LoginPage(this.driver);
    String actualPassword;

    public ChangePasswordPage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(this.driver);
    }

    By titleForm = By.xpath("//p[normalize-space()='Change Password']");
    By input_oldPassword = By.xpath("//input[@name='oldpassword']");
    By input_newPassword = By.xpath("//input[@name='newpassword']");
    By input_confirmPassword = By.xpath("//input[@name='confirmpassword']");
    By actualMessOldPass = By.xpath("//label[contains(text(),'Old Password must not be blank')]");
    By actualMessNewPass = By.xpath("//label[contains(text(),'New Password must not be blank')]");
    By actualMessConfirmPass = By.xpath("//label[contains(text(),'Confirm Password must not be blank')]");
    By bnt_submit = By.xpath("//input[@name='sub']");

    public void inputOldPassword(String oldPassword){
        WebElement oldPass = this.driver.findElement(this.input_oldPassword);
        String expectedMessage = "Old Password must not be blank";
        oldPass.sendKeys(oldPassword);
        actions.sendKeys(Keys.TAB).build().perform();
        if(oldPassword == ""){
            String actualMessage = this.driver.findElement(this.actualMessOldPass).getText();
            Assert.assertEquals(actualMessage,expectedMessage);
        }
    }

    public void inputNewPassword(String newPassword){
        WebElement newPass = this.driver.findElement(this.input_newPassword);
        String expectedMessage = "New Password must not be blank";
        newPass.sendKeys(newPassword);
        actions.sendKeys(Keys.TAB).build().perform();
        if(newPassword == ""){
            String actualMessage = this.driver.findElement(this.actualMessNewPass).getText();
            Assert.assertEquals(actualMessage,expectedMessage);
        }else {
            this.actualPassword = newPassword;
        }
    }

    public void inputConfirmPassword(String confirmPassword){
        WebElement confirmPass = this.driver.findElement(this.input_confirmPassword);
        String expectedMessage = "Confirm Password must not be blank";
        confirmPass.sendKeys(confirmPassword);
        actions.sendKeys(Keys.TAB).build().perform();
        if(confirmPassword == ""){
            String actualMessage = this.driver.findElement(this.actualMessConfirmPass).getText();
            Assert.assertEquals(actualMessage,expectedMessage);
        }else if(!confirmPassword.equals(this.actualPassword)){
            Assert.assertEquals(this.driver.findElement(By.xpath("//label[contains(text(),'Passwords do not Match')]")).getText(),"Passwords do not Match");
        }
    }

    public void clickSubmitButton(){
        this.driver.findElement(this.bnt_submit).click();
        System.out.println(this.actualPassword);
    }

    public void verifyMessageSuccessfully(){
      String messageSuccess =  this.driver.switchTo().alert().getText();
      String expectedMessage = "Password is Changed";
      Assert.assertEquals(messageSuccess,expectedMessage);
      this.driver.switchTo().alert().accept();
      loginPage.setPassword(this.actualPassword);
    }
    public void verifyChangePasswordPage(){
        WebElement titleForm = this.driver.findElement(this.titleForm);
        assert  titleForm.isDisplayed();
        Assert.assertEquals(titleForm.getText(),"Change Password");
    }
}
