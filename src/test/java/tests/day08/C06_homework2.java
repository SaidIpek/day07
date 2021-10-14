package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class C06_homework2 {
    /*
    https://www.saucedemo.com/ adresine gidin
     * Kullanıcı adını standard_user olarak girin
     * Şifreyi secret_sauce olarak girin
     * Giriş düğmesine tıklayın
     * Düşükten yükseğe fiyatı seçin
     * Ürün fiyatlarının düşükten yükseğe doğru sıralandığını doğrulayın
     */


    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        Thread.sleep(2000);
        driver.findElement(By.id("login-button")).click();

        //* Düşükten yükseğe fiyatı seçin

        WebElement dropDown = driver.findElement(By.className("product_sort_container"));
        Select select = new Select(dropDown);
        select.selectByValue("lohi");

        //* Ürün fiyatlarının düşükten yükseğe doğru sıralandığını doğrulayın


        String actual = driver.findElement(By.className("active_option")).getText();
        String expected = "PRICE (LOW TO HIGH)";

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actual, expected, "Sıralama istenildigi gibi degil.");


        softAssert.assertAll();


    }


    @AfterClass
    public void tearDown() {
        driver.close();
    }

}
