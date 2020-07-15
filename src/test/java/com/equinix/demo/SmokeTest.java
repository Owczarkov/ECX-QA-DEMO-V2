package com.equinix.demo;

import com.equinix.demo.components.ShelfItem;
import com.equinix.demo.components.ShoppingCart;
import com.equinix.demo.pages.MainShopPage;
import lombok.SneakyThrows;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SmokeTest extends BaseTest {

    @SneakyThrows
    @Test
    public void smokeTest() {
        MainShopPage mainShopPage = new MainShopPage();
        assertThat(mainShopPage.isVisible()).as("Main Shop page is NOT visible!").isTrue();
        assertThat(mainShopPage.getItems().stream().allMatch(AbstractComponent::isVisible)).as("One of item is NOT visible!").isTrue();

        ShelfItem randomItem = mainShopPage.getItems().get((int) getRandomNumber(mainShopPage.getItems().size()));
        String itemName = randomItem.name.getText();
        ShoppingCart shoppingCart = randomItem.addToCart();

        assertThat(shoppingCart.isVisible()).as("Shopping Cart is NOT visible!").isTrue();
        assertThat(itemName).isEqualTo(shoppingCart.getItems().get(0).name.getText());
    }
}
