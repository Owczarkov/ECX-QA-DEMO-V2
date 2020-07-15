package com.equinix.demo.components;

import lombok.val;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ShoppingCart extends BaseComponent {

    public ShoppingCart() {
        super(By.cssSelector(".float-cart--open"));
    }

    public List<CartItem> getItems() {
        val numberOfItems = findElements(byChained(elementLocator, By.cssSelector(".shelf-item"))).size();
        return IntStream.range(1, numberOfItems + 1)
                .mapToObj(i -> new CartItem(elementLocator, By.cssSelector(".shelf-item:nth-child(" + i + ")")))
                .collect(Collectors.toList());
    }
}
