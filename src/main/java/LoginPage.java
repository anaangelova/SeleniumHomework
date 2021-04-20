import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://www.netflix.com/mk/login");
    }

    public boolean isLoaded() throws InterruptedException {
        Thread.sleep(5000);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_userLoginId"))).isDisplayed();

    }

    public void login(String user, String password) throws InterruptedException {
        driver.findElement(By.id("id_userLoginId")).clear();
        driver.findElement(By.id("id_userLoginId")).sendKeys(user);
        Thread.sleep(5000);
        driver.findElement(By.id("id_password")).sendKeys(password);
        Thread.sleep(5000);
        driver.findElement(By.className("login-button")).click();
        Thread.sleep(5000);


    }


    public String getErrorMessage() {
        WebElement errorPage =driver.findElement(By.className("ui-message-contents"));
        return errorPage.getText();
    }
    public String getInvalidUsernameMessage() {
        WebElement errorPage =driver.findElement(By.className("inputError"));
        return errorPage.getText();
    }
}
