package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BaseTest;

import java.text.ParseException;

public class PracticeExam2 extends BaseTest {
    WebDriver driver;
    @DataProvider(name = "dataChangePassword")
    public Object[][] changePassword(){
        return new Object[][]{
                {"", "", "", "Please fill all fields"},
                {"123", "12345@", "12345@", "Old Password is incorrect"},
                {changePasswordPage.getActualPassword(),"1234567008@", "1234567008@","Password is Changed"}
        };
    }

    @DataProvider(name = "dataCreatNewCustomer")
    public Object[][] creatNewCustomer(){
        return new Object[][]{
                {"","", "", "","","","","","","","please fill all fields"},
                {"Nguyen Huong Thao","f", "02151989", "Hanoi","Hanoi","Cau Giay","12345","098765432","huongthao@gmail.com","12345678@","please fill all fields"},
                {"Nguyen Huong Thao","f", "02151989", "Hanoi","Hanoi","Cau Giay","123456","098765432","huongthao89@gmail.com","12345678@","Your User id is wrong please provide correct userid"},
                {"Nguyen Huong Thao","f", "02151989", "Hanoi","Hanoi","Cau Giay","12345","098765432","huongthao1@gmail.com","12345678@"},
        };
    }

    @DataProvider (name = "dataChangePassword")
    public Object[][] changePassword(){
        return new Object[][]{
                {"","","", "Please fill all fields"},
                {"12345678@", "12345678@", "112345678@","Please fill all fields"},
                {"000000000@", "12345688@", "12345688@", "Old Password is incorrect"},
                {ini_password, "12345688@", "12345688@", "Password is Changed"}
        };
    }

    @DataProvider (name ="dataCrateNewCustomer")
    public Object[][] createNewCustomer(){
        return  new Object[][]{
                {"", "", "", "", "", "","", "", "", "", "", "Please fill all fields"},
                {"", "", "", "", "", ""," ", "12345", "", "", "", "PIN Code must have 6 Digits"},
                {"Nguyen Huong Thao", "f", "02151989", "Hanoi", "Hanoi", "Cau Giay", "12345", "123456", "098765432", "huongthao"+(int)(Math.random()* 250 + 1)+"@gmail.com", "12345678@", "PIN Code must have 6 Digits"}

        };
    }

    @BeforeMethod()
    public void loginSuccess(){
        this.loginPage.inputUserName(BaseTest.ini_username);
        this.loginPage.inputPassword(changePasswordPage.getActualPassword());
        this.loginPage.clickLoginButton();
        this.homePage.verifyHomePage();
    }
<<<<<<< HEAD
@Test(priority = 1, dataProvider = "dataChangePassword")
public void testCaseChangePassword(String oldPassword, String newPassword, String confirmPassword, String result){
    this.homePage.clickMenuChangePassword();
    this.changePasswordPage.verifyChangePasswordPage();
    this.changePasswordPage.inputOldPassword(oldPassword);
    this.changePasswordPage.inputNewPassword(newPassword);
    this.changePasswordPage.inputConfirmPassword(confirmPassword);
    this.changePasswordPage.clickSubmitButton();
    String actualMessage = changePasswordPage.getMessageAlter();
    Assert.assertEquals(actualMessage, result);
    this.changePasswordPage.closeAlterMessage();
    if(actualMessage.equals("Password is Changed")) {
        this.changePasswordPage.setNewPassword();
        loginSuccess();
    }
}
=======
    @Test(priority = 1, dataProvider = "dataChangePassword")
    public void testCaseChangePassword(String oldPass, String newPass, String confirmPass, String result){
        this.homePage.clickMenuChangePassword();
        this.changePasswordPage.verifyChangePasswordPage();
        this.changePasswordPage.inputOldPassword(oldPass);
        this.changePasswordPage.inputNewPassword(newPass);
        this.changePasswordPage.inputConfirmPassword(confirmPass);
        this.changePasswordPage.clickSubmitButton();
        String actualMessage =  this.changePasswordPage.verifyMessageAlert();
        Assert.assertEquals(actualMessage,result);
        this.changePasswordPage.verifyMessageSuccessfully();
        this.changePasswordPage.acceptAlterPopup();
        if(result.equals("Password is Changed")){
            loginSuccess();
        }
    }
//
//        @Test(priority = 2)
//    public void ChangePassword_Fail_NewPassNotSameConfirmPass(){
//        this.homePage.clickMenuChangePassword();
//        this.changePasswordPage.inputOldPassword(loginPage.getPassword());
//        this.changePasswordPage.inputNewPassword("12345678@");
//        this.changePasswordPage.inputConfirmPassword("112345678@");
//
//    }
//    @Test(priority = 3)
//    public void testCaseChangePasswordSuccess(){
//        this.homePage.clickMenuChangePassword();
//        this.changePasswordPage.inputOldPassword(loginPage.getPassword());
//        this.changePasswordPage.inputNewPassword("12345678@");
//        this.changePasswordPage.inputConfirmPassword("12345678@");
//        this.changePasswordPage.clickSubmitButton();
//        this.changePasswordPage.verifyMessageSuccessfully();
//        loginSuccess();
//
//    }

>>>>>>> 161e3871f280c86213b4d7ad39a2d89e17b9190f
    @Test(priority = 4)
    public void testCaseCreateNewCustomerAllFieldsBlank() throws ParseException {
        this.homePage.clickMenuNewCustomer();
        this.newCustomerPage.verifyCustomerPage();
        this.newCustomerPage.inputCustomerName("");
        this.newCustomerPage.genderFemale();
        this.newCustomerPage.inputDateOfBirth("");
        this.newCustomerPage.inputAddress("");
        this.newCustomerPage.inputCity("");
        this.newCustomerPage.inputState("");
        this.newCustomerPage.inputPin("");
        this.newCustomerPage.inputMobileNumber("");
        this.newCustomerPage.inputEmail("");
        this.newCustomerPage.inputPassword("");

    }

    @Test(priority = 5)
    public void testCaseCreateNewCustomerFail_PinNot6Digits()  {
        this.homePage.clickMenuNewCustomer();
        this.newCustomerPage.verifyCustomerPage();
        this.newCustomerPage.inputPin("10000");

    }

    @Test(priority = 6)
    public void testCaseCreateNewCustomerSuccess() throws InterruptedException, ParseException {
        this.homePage.clickMenuNewCustomer();
        this.newCustomerPage.verifyCustomerPage();
        this.newCustomerPage.inputCustomerName("Nguyen Huong Thao");
        this.newCustomerPage.genderFemale();
        this.newCustomerPage.inputDateOfBirth("02151989");
        this.newCustomerPage.inputAddress("Hanoi");
        this.newCustomerPage.inputCity("Hanoi");
        this.newCustomerPage.inputState("Cau Giay");
        this.newCustomerPage.inputPin("123456");
        this.newCustomerPage.inputMobileNumber("098765432");
        this.newCustomerPage.inputEmail("huongthao"+(int)(Math.random()* 250 + 1)+"@gmail.com");
        this.newCustomerPage.inputPassword("12345678@");
        this.newCustomerPage.clickSubmitButton();
        this.newCustomerPage.verifyMessageSuccess();
        this.newCustomerPage.verifyInforNewCustomer();
        this.newCustomerPage.gotoHomePage();
    }
    @AfterMethod
    public void logout(){
        this.homePage.clickMenuLogout();
        this.homePage.verifyLogoutSuccess();
    }
}
