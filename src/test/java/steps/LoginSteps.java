package steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import java.time.Duration;

public class LoginSteps {
    WebDriver driver;
    LoginPage loginPage;

    @Given("Saya berada di halaman login SauceDemo")
    public void bukaHalamanLogin() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver); // Inisialisasi POM
    }

    @When("Saya memasukkan username {string} dan password {string}")
    public void inputKredensial(String username, String password) {
        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
    }

    @And("Saya menekan tombol login")
    public void tekanTombolLogin() {
        loginPage.klikLogin();
    }

    @Then("Saya diarahkan ke halaman utama")
    public void verifikasiHalamanUtama() {
        boolean adaLogo = driver.findElement(By.className("app_logo")).isDisplayed();
        Assert.assertTrue(adaLogo);
        driver.quit();
    }

    @Then("Saya melihat pesan error {string}")
    public void verifikasiPesanError(String pesanDiharapkan) {
        String pesanAsli = loginPage.getPesanError();
        Assert.assertEquals(pesanDiharapkan, pesanAsli);
        driver.quit();
    }
}