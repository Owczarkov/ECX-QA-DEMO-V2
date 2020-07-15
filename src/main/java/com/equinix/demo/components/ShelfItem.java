package com.equinix.demo.components;

import org.openqa.selenium.By;

public class ShelfItem extends BaseComponent {

    public final Label name = new Label(elementLocator, By.cssSelector(".shelf-item__title"));
    public final Button addToCartButton = new Button(elementLocator, By.cssSelector(".shelf-item__buy-btn"));

    public ShelfItem(By parentLocator, By itemLocator) {
        super(byChained(parentLocator, itemLocator));
    }

    public ShoppingCart addToCart() {
        addToCartButton.click();
        return new ShoppingCart();
    }
}
