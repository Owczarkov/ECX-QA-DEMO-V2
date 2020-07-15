package com.equinix.demo.pages;

import com.equinix.demo.components.ShelfItem;
import lombok.val;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MainShopPage extends AbstractPage {

    public MainShopPage() {
        super(By.cssSelector("#root main"));
    }

    public List<ShelfItem> getItems() {
        val numberOfItems = findElements(byChained(elementLocator, By.cssSelector(".shelf-item"))).size();
        return IntStream.range(2, numberOfItems + 2)
                .mapToObj(i -> new ShelfItem(elementLocator, By.cssSelector(".shelf-item:nth-child(" + i + ")")))
                .collect(Collectors.toList());
    }
}
