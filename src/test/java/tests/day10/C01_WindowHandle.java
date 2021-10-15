package tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.util.Set;

public class C01_WindowHandle extends TestBase {

    @Test
    public void test() {
        // ● Tests package’inda yeni bir class olusturun: C04_WindowHandle
        //● https://the-internet.herokuapp.com/windows adresine gidin.

        driver.get("https://the-internet.herokuapp.com/windows");

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.

        String actualYazi = driver.findElement(By.tagName("h3")).getText();
        String expectedYazi = "Opening a new window";

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualYazi, expectedYazi, "yazi istendigi gibi degil.");


        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.

        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        softAssert.assertEquals(actualTitle, expectedTitle, "title istenen degerden farklı");

        System.out.println("ilk sayfanın handle degeri : "+driver.getWindowHandle());
        //1.adım) window handle ederken  ilk adim 1 sayfa acik iken o sayfanin handle degerini alip bir String'e atamak.

        String ilkSayfaHandle= driver.getWindowHandle();


        //● Click Here butonuna basın
//bu satırda 2. window acıldı.
        driver.findElement(By.linkText("Click Here")).click();

//2.adım) 2 sayfa acildiginda her iki sayfanin handle degerlerini koymak icin bir set olusturup getWindowHandles methodu ile bu degerleri elde etmek.
     Set<String>tumWindowHandlelari= driver.getWindowHandles();
        System.out.println("Tum Handlelar : "+tumWindowHandlelari);
        //3.adım) set icerisinde birinci sayfanin handle degerine esit olmayan
        //handle degerini bulup bir String degiskenine atamak.

        String ikinciWindowHandle="";
        for (String each:tumWindowHandlelari) {

            if (!each.equals(ilkSayfaHandle)){
                ikinciWindowHandle=each;
            }

        }

        //bu satira geldigimizde elimizde 2.sayfanin handle degeri var olacak.

        System.out.println("ikinci sayfa handle degeri : "+ikinciWindowHandle);


        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.

        driver.switchTo().window(ikinciWindowHandle);
        //SwitchTo() ile window degistireceksek gidecegimiz window'un windowhandle'ina ihtiyacimiz var...
        String actualYeniTitle = driver.getTitle();
        String expectedYeniTitle = "New Window";
        softAssert.assertEquals(actualYeniTitle, expectedYeniTitle, "title istenen degerden farklı");

        //● Sayfadaki textin “New Window” olduğunu doğrulayın.

        WebElement yeniSayfaYaziElementi = driver.findElement(By.tagName("h3"));
        String expectedYaziYeniSayfa= "New Window";
        String actualSYaziYeniSayfa=yeniSayfaYaziElementi.getText();

        softAssert.assertEquals(actualSYaziYeniSayfa,expectedYaziYeniSayfa,"yeni sayfadaki yazi beklenenden farkli.");


        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.

        driver.switchTo().window(ilkSayfaHandle);
        actualTitle=driver.getTitle();

        softAssert.assertEquals(actualTitle, expectedTitle, "title istenen degerden farklı");



        softAssert.assertAll();


    }
}