package org.appium;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;

public class swipeGesture extends Base{

    @Test
    public void swipeGestureMethod(){

        driver.findElement(AppiumBy.accessibilityId("View")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(AppiumBy.accessibilityId("Photo")).click();

        WebElement firstImg = driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));

        /**
         * Before perform swipe
         */
        String bFirstImgFocus = firstImg.getAttribute("focusable");
        Assert.assertTrue(true, bFirstImgFocus);


        /**
         * Perform Swipe Action:
         */
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) firstImg).getId(),
                "direction", "left",
                "percent", 0.75
        ));

        /**
         * after perform swipe
         */
        String aFirstImgFocus = firstImg.getAttribute("focusable");
        Assert.assertTrue(false, aFirstImgFocus);
    }
}
