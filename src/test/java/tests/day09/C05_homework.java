package tests.day09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.List;

public class C05_homework extends TestBase {
    //go to web site : https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
    //maximize the web site
    //click on second emoji
    //click all second emoji's element
    //go back parent iframe
    //fill out the form,(Fill the form with the texts you want)
    //click on apply button

    @Test
    public void test(){

        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

        driver.switchTo().frame("emoojis");

        driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();

        List<WebElement> allEmojis=driver.findElements(By.xpath("//div[@class='mdl-tabs__panel is-active']/div/img"));
        for (WebElement each:allEmojis) {
            each.click();
        }

        driver.switchTo().defaultContent();










        }


    }







