package com.equinix.demo.pages;

import com.equinix.demo.AbstractComponent;
import org.openqa.selenium.By;

public abstract class AbstractPage extends AbstractComponent {

    public AbstractPage(By elementLocator) {
        super(elementLocator);
    }

    public void reloadPage() {
        driver.navigate().refresh();
    }
}
