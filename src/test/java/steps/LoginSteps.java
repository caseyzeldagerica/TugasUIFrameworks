package steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions; // Ini tambahan import-nya
import pages.LoginPage;

import java.time.Duration;

public class LoginSteps {
    WebDriver driver;
    LoginPage loginPage;

    @Given("Saya berada di halaman login SauceDemo")
    public void bukaHalamanLogin() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new"); // Pakai mode headless mesin Chrome versi terbaru
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu"); // Matikan akselerasi grafis yang sering bikin crash di Linux
        options.addArguments("--window-size=1920,1080"); // Beri ukuran layar virtual agar elemen web tidak bertumpuk
        options.addArguments("--remote-allow-origins=*"); // Buka izin akses penuh

        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
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