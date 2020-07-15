package com.equinix.demo.components;

import org.openqa.selenium.By;

public class Label extends BaseComponent {
    public Label(By parentLocator, By buttonLocator) {
        super(byChained(parentLocator, buttonLocator));
    }

}
