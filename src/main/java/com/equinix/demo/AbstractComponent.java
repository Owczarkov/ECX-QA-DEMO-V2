package com.equinix.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ByChained;

import java.util.List;

public abstract class AbstractComponent {
    protected WebDriver driver;
    public final By elementLocator;

    protected AbstractComponent(By elementLocator) {
        driver = DriverFactory.getDriver();
        this.elementLocator = elementLocator;
    }

    protected List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    protected WebElement findElement(By by) {
        return driver.findElement(by);
    }

    protected static ByChained byChained(By... bys) {
        return new ByChained(bys);
    }

    protected boolean isVisible() {
        return findElement(elementLocator).isDisplayed();
    }

}
