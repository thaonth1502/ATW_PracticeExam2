package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class BaseTest {
    WebDriver driver;
    public static String ini_username;
    public static String ini_password;
    public LoginPage loginPage;
    public HomePage homePage;
    public ChangePasswordPage changePasswordPage;
    public NewCustomerPage newCustomerPage;

    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        this.driver.get("https://www.demo.guru99.com/");
        this.driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys("huongthao89@gmail.com");
        this.driver.findElement(By.xpath("//input[@name = 'btnLogin']")).click();
        ini_username = this.driver.findElement(By.xpath("//tbody/tr[4]/td[2]")).getText();
        ini_password = this.driver.findElement(By.xpath("//tbody/tr[5]/td[2]")).getText();
        this.driver.navigate().to("https://www.demo.guru99.com/v4/");
        this.loginPage = new LoginPage(this.driver);
        this.homePage = new HomePage(this.driver);
        this.changePasswordPage = new ChangePasswordPage(this.driver);
        this.newCustomerPage = new NewCustomerPage(this.driver);
    }
    @AfterTest
    public void after(){
        this.driver.quit();
    }
}
