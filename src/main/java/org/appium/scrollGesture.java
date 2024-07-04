package org.appium;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.JavascriptExecutor;

public class scrollGesture extends Base{

    public void mobileScrollDesture(){
        driver.findElement(AppiumBy.accessibilityId("View")).click();

        /**
         * Approach 01: Scroll until view an element
         *
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector())" +
                ".scrollIntoView(text(\"webView\"))"));
        */
        scrollToElement("webView");

        /**
         * Approach 02: If you have to scroll as long as you have the page

        boolean canScrollMore;

        do {
            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 200, "height", 200,
                    "direction", "down",
                    "percent", 1.0
            ));
        } while (canScrollMore);
         */

        scrollEnd();


    }
}
