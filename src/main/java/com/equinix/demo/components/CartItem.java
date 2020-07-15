package com.equinix.demo.components;

import org.openqa.selenium.By;

public class CartItem extends BaseComponent {

    public final Label name = new Label(elementLocator, By.cssSelector(".title"));

    public CartItem(By parentLocator, By cartLocator) {
        super(byChained(parentLocator, cartLocator));
    }

}
