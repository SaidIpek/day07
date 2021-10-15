package tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C02_Actions extends TestBase {

    //amazon ana sayfa'ya gidin.
    //nutella icin arama yapın.
    //9. urunu tiklayin.

    @Test
    public void test() throws InterruptedException {

        driver.get("https://www.amazon.com");

        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("nutella"+ Keys.ENTER);

        driver.findElement(By.xpath("(//span[@class='a-size-base a-color-base a-text-normal'])[9]")).click();


    }
}
