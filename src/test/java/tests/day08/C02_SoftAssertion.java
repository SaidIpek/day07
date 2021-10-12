package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class C02_SoftAssertion {

    //amazon sayfasına gidin
    //url'in amazon icerdigini test edin.
    //title'in amazon icerdigini test edin.
    //java kelimesi aratin ve ilk listedeki ilk urunun java kelimesi icerdigini tst edin.
    //testleri soft assetion ile yapın



    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }


    @Test
    public void test(){
        SoftAssert softAssert = new SoftAssert();
        driver.get("https://www.amazon.com");

        //url'in amazon icerdigini test edin.
        softAssert.assertTrue(driver.getCurrentUrl().contains("amazon"),"url amazon içermiyor.");

        //title'in amazon icerdigini test edin.

        softAssert.assertTrue(driver.getTitle().contains("Amazon"),"title Amazon icermiyor.");

        //java kelimesi aratin ve ilk listedeki ilk urunun java kelimesi icerdigini tst edin.

        WebElement aramakutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramakutusu.sendKeys("java"+ Keys.ENTER);
        WebElement ilkUrun = driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]"));
        softAssert.assertTrue(ilkUrun.getText().contains("Java"),"ilk urun Java icermiyor.");

        softAssert.assertAll();

        //tum assertion'lar pass olsa da olmasa da assertALL'a kadar tum satirlar calisir.
        //eger testlerden bir tanesi bile FAILED ise asertALL'dan sonra execution stops.


    }



    @AfterClass
    public void tearDown(){
        driver.close();
    }
}
