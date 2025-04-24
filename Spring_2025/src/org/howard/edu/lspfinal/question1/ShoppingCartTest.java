package org.howard.edu.lspfinal.question1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the ShoppingCart class.
 * Covers scenarios including valid/invalid inputs and discount logic.
 */
public class ShoppingCartTest {

    @Test
    @DisplayName("Add a single valid item and check total")
    public void testAddValidItem() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Apple", 1.99);
        // Total should match the item's price
        assertEquals(1.99, cart.getTotalCost(), 0.001);
    }

    @Test
    @DisplayName("Try to add an item with zero price (should throw exception)")
    public void testAddItemZeroPrice() {
        ShoppingCart cart = new ShoppingCart();
        // Zero price should trigger IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            cart.addItem("FreeSample", 0);
        });
    }

    @Test
    @DisplayName("Try to add item with negative price (should throw exception)")
    public void testAddItemNegativePrice() {
        ShoppingCart cart = new ShoppingCart();
        // Negative prices aren't allowed
        assertThrows(IllegalArgumentException.class, () -> {
            cart.addItem("InvalidItem", -5.0);
        });
    }

    @Test
    @DisplayName("Apply SAVE10 discount code and check discount")
    public void testApplySave10() {
        ShoppingCart cart = new ShoppingCart();
        cart.applyDiscountCode("SAVE10");
        // SAVE10 should apply 10% discount
        assertEquals(10.0, cart.getDiscountPercentage());
    }

    @Test
    @DisplayName("Apply SAVE20 discount code and check discount")
    public void testApplySave20() {
        ShoppingCart cart = new ShoppingCart();
        cart.applyDiscountCode("SAVE20");
        // SAVE20 should apply 20% discount
        assertEquals(20.0, cart.getDiscountPercentage());
    }

    @Test
    @DisplayName("Try to apply invalid discount code (should throw exception)")
    public void testApplyInvalidDiscountCode() {
        ShoppingCart cart = new ShoppingCart();
        // Unsupported codes like SAVE50 should throw an error
        assertThrows(IllegalArgumentException.class, () -> {
            cart.applyDiscountCode("SAVE50");
        });
    }

    @Test
    @DisplayName("Get total without any discounts applied")
    public void testTotalWithoutDiscount() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Item1", 5.0);
        cart.addItem("Item2", 10.0);
        // No discount applied, so total should be 15.0
        assertEquals(15.0, cart.getTotalCost(), 0.001);
    }

    @Test
    @DisplayName("Get total after applying 10% discount")
    public void testTotalWithDiscount() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Item1", 10.0);
        cart.addItem("Item2", 10.0);
        cart.applyDiscountCode("SAVE10");
        // 10% off $20 is $18
        assertEquals(18.0, cart.getTotalCost(), 0.001);
    }

    @Test
    @DisplayName("Check total for empty cart (should be zero)")
    public void testTotalEmptyCart() {
        ShoppingCart cart = new ShoppingCart();
        // No items = total cost should be zero
        assertEquals(0.0, cart.getTotalCost(), 0.001);
    }

    @Test
    @DisplayName("Remove an item that exists and verify cart updates")
    public void testRemoveExistingItem() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Orange", 2.0);
        cart.addItem("Banana", 1.5);
        // Remove "Orange" from the cart
        cart.items.remove("Orange");
        // Ensure "Orange" is gone
        assertFalse(cart.items.containsKey("Orange"));
        // Remaining total should reflect only "Banana"
        assertEquals(1.5, cart.getTotalCost(), 0.001);
    }

    @Test
    @DisplayName("Attempt to remove an item that isn't in the cart")
    public void testRemoveNonExistentItem() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Apple", 3.0);
        // Removing an item that doesn’t exist shouldn't cause errors
        cart.items.remove("NonexistentItem");
        // Cart total should still be correct
        assertEquals(3.0, cart.getTotalCost(), 0.001);
    }
}
