package org.appium;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class setWifi extends Base{

    Base base = new Base();



    @Test
    public void setWifiTest(){

        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        String titleName = driver.findElement(By.xpath("//android.widget.TextView[@text=\'API Demos\']")).getText();
        Assert.assertEquals(titleName, "API Demos");

        driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
        String depdenName = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\'android:id/title\' and @text=\'Example preference dependency\']")).getText();
        Assert.assertEquals(depdenName, "Example preference dependency");

        String tagName = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\'android:id/title\' and @text=\'WiFi\']")).getText();
        Assert.assertEquals(tagName, "WIFI");

        driver.findElement(By.id("android:id/checkbox")).click();

        String wifiSetting = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\'android:id/title\' and @text=\'WiFi settings\']")).getText();
        Assert.assertEquals(wifiSetting, "WIFI settings");

        driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\'android:id/title\' and @text=\'WiFi settings\']")).click();
        driver.findElement(By.id("\t\n" + "android:id/edit")).sendKeys("Vikiwifi");

        driver.findElement(By.id("android:id/button1")).click();

    }
}
