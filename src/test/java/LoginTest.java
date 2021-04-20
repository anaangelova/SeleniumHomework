import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest {
    private WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = getDriver();
    }


    @Test
    public void itShouldOpen() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        assertTrue(loginPage.isLoaded());
    }

    @Test
    public void canNotLoginWithInvalidPassword() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        assertTrue(loginPage.isLoaded());
        loginPage.login("angelova99999@gmail.com", "test123");
        String errorMessage = loginPage.getErrorMessage();
        assertEquals(errorMessage, "Incorrect password. Please try again or you can reset your password.");


    }

    @Test
    public void canNotLoginWithInvalidUserName() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        assertTrue(loginPage.isLoaded());
        loginPage.login("angeloavva99999@gmail.com", "test123");
        String errorMessage = loginPage.getErrorMessage();
        assertEquals(errorMessage, "Sorry, we can't find an account with this email address. Please try again or create a new account.");


    }

    @Test
    public void canNotLoginWithEmptyUsername() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        assertTrue(loginPage.isLoaded());
        loginPage.login("", "test123");
        String errorMessage = loginPage.getInvalidUsernameMessage();
        assertEquals(errorMessage, "Please enter a valid email or phone number.");


    }


    @Test
    public void shouldLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        assertTrue(loginPage.isLoaded());
        loginPage.login("janedoe999991@outlook.com", "ExampleTest123!");
        assertTrue(new HomePage(driver).isLoaded());

    }
    private WebDriver getDriver() { //go inicijalizira web driver
        System.setProperty("webdriver.chrome.driver", "D:\\6ти семестар\\Софтверски квалитет и тестирање\\Домашни задачи\\SeleniumHomework183016\\src\\main\\resources\\chromedriver.exe");
        return new ChromeDriver();
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }
}
