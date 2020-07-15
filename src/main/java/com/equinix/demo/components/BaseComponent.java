package com.equinix.demo.components;

import com.equinix.demo.AbstractComponent;
import org.openqa.selenium.By;

public class BaseComponent extends AbstractComponent {

    public BaseComponent(By elementLocator) {
        super(elementLocator);
    }

    public boolean isEnabled() {
        return findElement(elementLocator).isEnabled();
    }

    public String getText() {
        return findElement(elementLocator).getText();
    }
}
