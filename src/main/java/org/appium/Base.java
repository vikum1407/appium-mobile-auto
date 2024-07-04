package org.appium;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Base {
    public AndroidDriver driver;
    public AppiumDriverLocalService server;

    @BeforeClass
    public void configAppium() throws MalformedURLException {

        /**
         * Run the appium server automatically
         */
        server = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\Vikum Sugathadasa\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib"))
                .withIPAddress("http://127.0.0.1:4723").usingPort(4723).withTimeout(Duration.ofSeconds(3000)).build();
        server.start();

        /**
         * Create Capabilities
         */
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("GalaxyNexusDevice");
        options.setApp(System.getProperty("user.dir")+"\\Vikum\\SDET\\Appium\\appiumAuto\\resources\\ApiDemos-debug.apk");

        /**
         * Create object for AndroidDriver/ ISODriver
         */
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        /**
         * Object click through the element
         */
        //driver.findElement(AppiumBy.accessibilityId("Preference")).click();

    }

    public void scrollEnd(){
        boolean canScrollMore;

        do {
            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 200, "height", 200,
                    "direction", "down",
                    "percent", 1.0
            ));
        } while (canScrollMore);
    }

    public void scrollToElement(String element){
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector())" +
                ".scrollIntoView(text(\"element\"))"));
    }

    @AfterClass
    public void tierDown(){
        driver.quit();
        server.stop();
    }
}
