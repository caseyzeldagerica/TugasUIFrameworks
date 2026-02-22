package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    // Locators
    By fieldUsername = By.id("user-name");
    By fieldPassword = By.id("password");
    By tombolLogin = By.id("login-button");
    By pesanError = By.cssSelector("[data-test='error']");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void inputUsername(String username) {
        driver.findElement(fieldUsername).sendKeys(username);
    }

    public void inputPassword(String password) {
        driver.findElement(fieldPassword).sendKeys(password);
    }

    public void klikLogin() {
        driver.findElement(tombolLogin).click();
    }

    public String getPesanError() {
        return driver.findElement(pesanError).getText();
    }
}