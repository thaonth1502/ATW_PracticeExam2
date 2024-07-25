package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class NewCustomerPage {
    WebDriver driver;
    Actions actions;
    String customerName;
    String gender;
    String dateOfBirth;
    String address;
    String city;
    String state;
    String pin;
    String mobile;
    String email;


    public NewCustomerPage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(this.driver);
    }

    By titlePageCustomer = By.xpath("//p[normalize-space()='Add New Customer'] ");
    By inputCusName = By.xpath("//input[@name='name']");
    By genderFemale = By.xpath("//input[@value='f']");
    By genderMale = By.xpath("//input[@value='m']");
    By inputDateOfBirth = By.xpath("//input[@id='dob']");
    By inputAddress = By.xpath("//textarea[@name='addr']");
    By inputCity = By.xpath("//input[@name='city']");
    By inputState = By.xpath("//input[@name='state']");
    By inputPIN = By.xpath("//input[@name='pinno']");
    By inputMobileNumber = By.xpath("//input[@name='telephoneno']");
    By inputEmail = By.xpath("//input[@name='emailid']");
    By inputPassword = By.xpath("//input[@name='password']");
    By btn_Submit = By.xpath("//input[@name='sub']");

    public void verifyMessageSuccess(){
        String messageSuccess = this.driver.findElement(By.xpath("//p[normalize-space()='Customer Registered Successfully!!!']")).getText();
        String expectedMessage = "Customer Registered Successfully!!!";
        Assert.assertEquals(messageSuccess,expectedMessage);
    }

    public void verifyInforNewCustomer(){
        List<WebElement> elements = this.driver.findElements(By.xpath("//table[@id = 'customer']//tr[4]/following-sibling::tr/td[2]"));
        List<String> newCustomerInfor = new ArrayList<String>();
        for (WebElement element : elements){
            newCustomerInfor.add(element.getText());
        }
        List<String> expectedCusInfor = new ArrayList<String>();
        expectedCusInfor.add(this.customerName);
        expectedCusInfor.add(this.gender);
        expectedCusInfor.add(this.dateOfBirth);
        expectedCusInfor.add(this.address);
        expectedCusInfor.add(this.city);
        expectedCusInfor.add(this.state);
        expectedCusInfor.add(this.pin);
        expectedCusInfor.add(this.mobile);
        expectedCusInfor.add(this.email);

        for (int i = 0 ; i < expectedCusInfor.size(); i ++){
            Assert.assertEquals (newCustomerInfor.get(i),expectedCusInfor.get(i));
        }
    }

    public void clickSubmitButton(){
        WebElement element = this.driver.findElement(this.btn_Submit);
        actions.moveToElement(element).build().perform();
        element.click();
    }

    public void inputPassword(String password){
        WebElement element = this.driver.findElement(this.inputPassword);
        actions.moveToElement(element).build().perform();
        String expectedMessage = "Password must not be blank";
        element.sendKeys(password);
        actions.sendKeys(Keys.TAB).build().perform();
        if(password == ""){
            String actualMessage = this.driver.findElement(By.xpath("(//label[normalize-space()='Password must not be blank'])")).getText();
            Assert.assertEquals(actualMessage,expectedMessage);
        }
    }

    public void inputEmail(String email){
        WebElement element = this.driver.findElement(this.inputEmail);
        actions.moveToElement(element).build().perform();
        String expectedMessage = "Email-ID must not be blank";
        element.sendKeys(email);
        actions.sendKeys(Keys.TAB).build().perform();
        if(email == ""){
            String actualMessage = this.driver.findElement(By.xpath("(//label[normalize-space()='Email-ID must not be blank'])")).getText();
            Assert.assertEquals(actualMessage,expectedMessage);
        }else {
            this.email = email;
        }
    }

    public void inputMobileNumber(String mobileNo){
        WebElement element = this.driver.findElement(this.inputMobileNumber);
        actions.moveToElement(element).build().perform();
        String expectedMessage = "Mobile no must not be blank";
        element.sendKeys(mobileNo);
        actions.sendKeys(Keys.TAB).build().perform();
        if(mobileNo == ""){
            String actualMessage = this.driver.findElement(By.xpath("(//label[normalize-space()='Mobile no must not be blank'])")).getText();
            Assert.assertEquals(actualMessage,expectedMessage);
        }else {
            this.mobile = mobileNo;
        }
    }

    public void inputPin(String pin){
        WebElement element = this.driver.findElement(this.inputPIN);
        actions.moveToElement(element).build().perform();
        String expectedMessage = "PIN Code must not be blank";
        element.sendKeys(pin);
        actions.sendKeys(Keys.TAB).build().perform();
        if(pin == ""){
            String actualMessage = this.driver.findElement(By.xpath("(//label[normalize-space()='PIN Code must not be blank'])")).getText();
            Assert.assertEquals(actualMessage,expectedMessage);
        } else if (pin.length()<6) {
            String actualMessage = this.driver.findElement(By.xpath("(//label[normalize-space()='PIN Code must have 6 Digits'])")).getText();
            Assert.assertEquals(actualMessage,"PIN Code must have 6 Digits");
        }else {
            this.pin = pin;
        }
    }

    public void inputState(String state){
        WebElement element = this.driver.findElement(this.inputState);
        actions.moveToElement(element).build().perform();
        String expectedMessage = "State must not be blank";
        element.sendKeys(state);
        actions.sendKeys(Keys.TAB).build().perform();
        if(state == ""){
            String actualMessage = this.driver.findElement(By.xpath("(//label[normalize-space()='State must not be blank'])")).getText();
            Assert.assertEquals(actualMessage,expectedMessage);
        }else {
            this.state = state;
        }
    }

    public void inputCity(String city){
        WebElement element = this.driver.findElement(this.inputCity);
        actions.moveToElement(element).build().perform();
        String expectedMessage = "City Field must not be blank";
        element.sendKeys(city);
        actions.sendKeys(Keys.TAB).build().perform();
        if(city == ""){
            String actualMessage = this.driver.findElement(By.xpath("(//label[normalize-space()='City Field must not be blank'])")).getText();
            Assert.assertEquals(actualMessage,expectedMessage);
        }else {
            this.city = city;
        }
    }

    public void inputAddress(String address){
        WebElement element = this.driver.findElement(this.inputAddress);
        actions.moveToElement(element).build().perform();
        String expectedMessage = "Address Field must not be blank";
        element.sendKeys(address);
        actions.sendKeys(Keys.TAB).build().perform();
        if(address == ""){
            String actualMessage = this.driver.findElement(By.xpath("(//label[normalize-space()='Address Field must not be blank'])")).getText();
            Assert.assertEquals(actualMessage,expectedMessage);
        }else {
            this.address = address;
        }
    }

    public void inputDateOfBirth(String dob) throws ParseException {
        WebElement element = this.driver.findElement(this.inputDateOfBirth);
        actions.moveToElement(element).build().perform();
        String expectedMessage = "Date Field must not be blank";
        element.sendKeys(dob);
        actions.sendKeys(Keys.TAB).build().perform();
        if(dob == ""){
            String actualMessage = this.driver.findElement(By.xpath("(//label[normalize-space()='Date Field must not be blank'])")).getText();
            Assert.assertEquals(actualMessage,expectedMessage);
        }
        else {
           this.dateOfBirth = dob;
           SimpleDateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
           SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
           this.dateOfBirth = date.format(dateFormat.parse(this.dateOfBirth));
        }
    }

    public void genderFemale(){
        this.driver.findElement(this.genderFemale).click();
        String value = this.driver.findElement(this.genderFemale).getAttribute("value");
        if(value.equals("f")){
            this.gender = "female";
        }else {
            this.gender = "male";
        }
    }

    public void inputCustomerName(String cusName){
        WebElement element = this.driver.findElement(this.inputCusName);
        actions.moveToElement(element).build().perform();
        String expectedMessage = "Customer name must not be blank";
        element.sendKeys(cusName);
        actions.sendKeys(Keys.TAB).build().perform();
        if(cusName == ""){
            String actualMessage = this.driver.findElement(By.xpath("(//label[normalize-space()='Customer name must not be blank'])")).getText();
            Assert.assertEquals(actualMessage,expectedMessage);
        }else {
            this.customerName = cusName;
        }
    }

    public void verifyCustomerPage(){
        WebElement titleNewCustomerPage = this.driver.findElement(this.titlePageCustomer);
        titleNewCustomerPage.isDisplayed();
        Assert.assertEquals(titleNewCustomerPage.getText(),"Add New Customer");
    }

    public void gotoHomePage(){
        WebElement homeMenu = this.driver.findElement(By.xpath("//a[text()='Home']"));
        actions.moveToElement(homeMenu).build().perform();
        homeMenu.click();
    }
}
