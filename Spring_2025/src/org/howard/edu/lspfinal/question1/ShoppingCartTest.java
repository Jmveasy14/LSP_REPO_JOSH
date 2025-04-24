package org.howard.edu.lspfinal.question1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartTest {

    @Test
    @DisplayName("Test adding valid item")
    public void testAddValidItem() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Apple", 1.99);
        assertEquals(1.99, cart.getTotalCost(), 0.001);
    }

    @Test
    @DisplayName("Test adding item with 0 price (expect exception)")
    public void testAddItemZeroPrice() {
        ShoppingCart cart = new ShoppingCart();
        assertThrows(IllegalArgumentException.class, () -> {
            cart.addItem("FreeSample", 0);
        });
    }

    @Test
    @DisplayName("Test adding item with negative price (expect exception)")
    public void testAddItemNegativePrice() {
        ShoppingCart cart = new ShoppingCart();
        assertThrows(IllegalArgumentException.class, () -> {
            cart.addItem("InvalidItem", -5.0);
        });
    }

    @Test
    @DisplayName("Test applying 'SAVE10'")
    public void testApplySave10() {
        ShoppingCart cart = new ShoppingCart();
        cart.applyDiscountCode("SAVE10");
        assertEquals(10.0, cart.getDiscountPercentage());
    }

    @Test
    @DisplayName("Test applying 'SAVE20'")
    public void testApplySave20() {
        ShoppingCart cart = new ShoppingCart();
        cart.applyDiscountCode("SAVE20");
        assertEquals(20.0, cart.getDiscountPercentage());
    }

    @Test
    @DisplayName("Test applying invalid code (expect exception)")
    public void testApplyInvalidDiscountCode() {
        ShoppingCart cart = new ShoppingCart();
        assertThrows(IllegalArgumentException.class, () -> {
            cart.applyDiscountCode("SAVE50");
        });
    }

    @Test
    @DisplayName("Test total cost without discount")
    public void testTotalWithoutDiscount() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Item1", 5.0);
        cart.addItem("Item2", 10.0);
        assertEquals(15.0, cart.getTotalCost(), 0.001);
    }

    @Test
    @DisplayName("Test total cost with discount")
    public void testTotalWithDiscount() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Item1", 10.0);
        cart.addItem("Item2", 10.0);
        cart.applyDiscountCode("SAVE10");
        assertEquals(18.0, cart.getTotalCost(), 0.001);
    }

    @Test
    @DisplayName("Test total cost with empty cart")
    public void testTotalEmptyCart() {
        ShoppingCart cart = new ShoppingCart();
        assertEquals(0.0, cart.getTotalCost(), 0.001);
    }

    @Test
    @DisplayName("Test removing existing item")
    public void testRemoveExistingItem() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Orange", 2.0);
        cart.addItem("Banana", 1.5);
        cart.items.remove("Orange");
        assertFalse(cart.items.containsKey("Orange"));
        assertEquals(1.5, cart.getTotalCost(), 0.001);
    }

    @Test
    @DisplayName("Test removing non-existent item")
    public void testRemoveNonExistentItem() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Apple", 3.0);
        cart.items.remove("NonexistentItem"); // Should not throw error
        assertEquals(3.0, cart.getTotalCost(), 0.001);
    }
}
