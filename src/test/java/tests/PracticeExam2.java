package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.BaseTest;

import java.text.ParseException;

public class PracticeExam2 extends BaseTest {
    WebDriver driver;

    @Test(priority = 0)
    public void login(){
        //  System.out.println(BaseTest.ini_username);
        System.out.println(BaseTest.ini_password);
        this.loginPage.inputUserName(BaseTest.ini_username);
        this.loginPage.inputPassword(loginPage.getPassword());
        this.loginPage.clickLoginButton();
        this.homePage.verifyHomePage();
    }

    @Test(priority = 1)
    public void testCaseChangePasswordRequiredBlank(){
        this.homePage.clickMenuChangePassword();
        this.changePasswordPage.verifyChangePasswordPage();
        this.changePasswordPage.inputOldPassword("");
        this.changePasswordPage.inputNewPassword("");
        this.changePasswordPage.inputConfirmPassword("");
        this.homePage.clickMenuLogout();
        this.homePage.verifyLogoutSuccess();
    }

        @Test(priority = 2)
    public void ChangePassword_Fail_NewPassNotSameConfirmPass(){
        login();
        this.homePage.clickMenuChangePassword();
        this.changePasswordPage.inputOldPassword(loginPage.getPassword());
        this.changePasswordPage.inputNewPassword("12345678@");
        this.changePasswordPage.inputConfirmPassword("112345678@");
        this.homePage.clickMenuLogout();
        this.homePage.verifyLogoutSuccess();
    }
    @Test(priority = 3)
    public void testCaseChangePasswordSuccess(){
        login();
        this.homePage.clickMenuChangePassword();
        this.changePasswordPage.inputOldPassword(loginPage.getPassword());
        this.changePasswordPage.inputNewPassword("123488888@");
        this.changePasswordPage.inputConfirmPassword("123488888@");
        this.changePasswordPage.clickSubmitButton();
        this.changePasswordPage.verifyMessageSuccessfully();
        login();
        this.homePage.clickMenuLogout();
        this.homePage.verifyLogoutSuccess();
    }

    @Test(priority = 4)
    public void testCaseCreateNewCustomerAllFieldsBlank(){
        login();
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
        this.homePage.clickMenuLogout();
        this.homePage.verifyLogoutSuccess();
    }

    @Test(priority = 5)
    public void testCaseCreateNewCustomerFail_PinNot6Digits()  {
        login();
        this.homePage.clickMenuNewCustomer();
        this.newCustomerPage.verifyCustomerPage();
        this.newCustomerPage.inputPin("10000");
        this.homePage.clickMenuLogout();
        this.homePage.verifyLogoutSuccess();
    }

    @Test(priority = 6)
    public void testCaseCreateNewCustomerSuccess() throws InterruptedException, ParseException {
        login();
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
       // this.newCustomerPage.verifyInforNewCustomer();
//        this.homePage.clickMenuLogout();
//        this.homePage.verifyLogoutSuccess();
    }
}
