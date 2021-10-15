package tests.day11;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist extends TestBase {

    @Test
    public void test(){

        System.out.println(System.getProperty("user.home"));
        //C:\Users\Excalıbur\Desktop\picture.jpg

        //Masaustundeki bir dosya yolunun tum pc'lerde sorunsuz calismasi icin
        //dosya yolunu 2'ye ayıracagız:
        //1. herkesin pc'sinde farkli olan kisim
        //bu kismi pc'den System.getProperty("user.home") kodu ile alabiliriz.
        //2. herkes icin ayni olan kisim
        //bu kisim 1. maddedeki yolun devami seklinde olur.


        //ornek masaustumuzdeki picture dosyasi icin yol kaydedelim.

        String dosyaYolu = System.getProperty("user.home")+ "\\Desktop\\picture.jpg";

        System.out.println("dosya yolumuz : "+ dosyaYolu);

        System.out.println(Files.exists(Paths.get(dosyaYolu)));

        Assert.assertTrue(Files.exists (Paths.get (dosyaYolu)));


        System.out.println(System.getProperty("user.dir"));
        //icinde oldugumuz dosyanın yolunu verir.






    }


}
