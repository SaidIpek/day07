package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {
    //abstract yaparak bu class'dan obje olusturulmasının onune geciyoruz.
protected   WebDriver driver;

//biz tesbase class'i sadece extends ile inherit ederek kullancagız
    //dolayisiyla olusturdugumuz driver variable'i icin protected access modifier'i seciyoruz


    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }
}
