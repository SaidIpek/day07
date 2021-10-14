package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class C05_homework {
    //1. Bir class oluşturun : AmazonSearchTest
    //2. Main method oluşturun ve aşağıdaki görevi tamamlayın.
    // a.google web sayfasına gidin. https://www. amazon.com/
    // b. Search(ara) “city bike”
    // c. Amazon'da görüntülenen ilgili sonuçların sayısını yazdırın
    // d. “Shopping” e tıklayın.
    // e. Sonra karşınıza çıkan ilk sonucun resmine tıklayın.


    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com/");
    }

    @Test
    public void test(){

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("city bike"+ Keys.ENTER);
       WebElement sonucSayisi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonucSayisi.getText());



    }



}
