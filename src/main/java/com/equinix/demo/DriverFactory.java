package com.equinix.demo;

import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverFactory() {
        throw new UnsupportedOperationException("This class should not have instance");
    }

    public static void setDriver(String url) {
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        if (getDriver() == null) {
            WebDriver webDriver = new ChromeDriver();
            DriverFactory.driver.set(webDriver);
            setDriverProperties(url);
        }
    }

    private static void setDriverProperties(String url) {
        driver.get().manage().window().maximize();
        driver.get().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.get().manage().deleteAllCookies();
        driver.get().get(url);
    }

    private static int i=0;

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        i++;
        System.out.println("syncTestBroken" + i);
        driver.get().quit();
        driver.remove();
    }
}
