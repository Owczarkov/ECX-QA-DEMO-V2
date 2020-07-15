package com.equinix.demo.components;

import org.openqa.selenium.By;

public class Button extends BaseComponent {
    public Button(By parentLocator, By buttonLocator) {
        super(byChained(parentLocator, buttonLocator));
    }

    public void click() {
        findElement(elementLocator).click();
    }
}
