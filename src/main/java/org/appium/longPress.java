package org.appium;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class longPress extends Base{

    @Test
    public void longPressTest(){
        driver.findElement(AppiumBy.accessibilityId("View")).click();
        driver.findElement(AppiumBy.accessibilityId("Extendable Lists")).click();
        driver.findElement(AppiumBy.accessibilityId("Customer Adapter")).click();
        WebElement longele = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));

        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) longele).getId()), "duration", 2000);

        WebElement peoMenu = driver.findElement(By.xpath("android:id/title"));
        String peopleText = peoMenu.getText();
        Assert.assertEquals(peopleText, "Sample Menu");

        boolean display = peoMenu.isDisplayed();
        Assert.assertTrue(display);
    }
}
