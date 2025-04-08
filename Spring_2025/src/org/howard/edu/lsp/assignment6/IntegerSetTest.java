package org.howard.edu.lsp.assignment6;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class IntegerSetTest {
    private IntegerSet set1;
    private IntegerSet set2;
    
    @BeforeEach
    void setUp() {
        set1 = new IntegerSet();
        set2 = new IntegerSet();
    }

    @Test
    @DisplayName("Test case for clear")
    public void testClear() {
        // Add some elements to the set
        set1.add(1);
        set1.add(2);
        set1.add(3);
        
        // Clear the set
        set1.clear();
        
        // Check if the set is empty
        assertTrue(set1.isEmpty());
        assertEquals(0, set1.length());
    }
    
    @Test
    @DisplayName("Test case for length")
    public void testLength() {
        // Test empty set
        assertEquals(0, set1.length());
        
        // Add elements and test
        set1.add(1);
        assertEquals(1, set1.length());
        
        // Add more elements
        set1.add(2);
        set1.add(3);
        assertEquals(3, set1.length());
        
        // Add duplicate (should not change length)
        set1.add(1);
        assertEquals(3, set1.length());
    }
    
    @Test
    @DisplayName("Test case for equals")
    public void testEquals() {
        // Empty sets should be equal
        assertTrue(set1.equals(set2));
        
        // Sets with same elements should be equal regardless of order
        set1.add(1);
        set1.add(2);
        set1.add(3);
        
        set2.add(3);
        set2.add(1);
        set2.add(2);
        
        assertTrue(set1.equals(set2));
        
        // Sets with different elements should not be equal
        set2.add(4);
        assertFalse(set1.equals(set2));
        
        // Sets with different sizes should not be equal
        set1.clear();
        set1.add(1);
        assertFalse(set1.equals(set2));
    }
    
    @Test
    @DisplayName("Test case for contains")
    public void testContains() {
        // Empty set should not contain any element
        assertFalse(set1.contains(1));
        
        // Test with elements
        set1.add(1);
        set1.add(2);
        set1.add(3);
        
        assertTrue(set1.contains(1));
        assertTrue(set1.contains(2));
        assertTrue(set1.contains(3));
        assertFalse(set1.contains(4));
    }
    
    @Test
    @DisplayName("Test case for largest")
    public void testLargest() throws IntegerSetException {
        // Add elements and test
        set1.add(1);
        set1.add(5);
        set1.add(3);
        
        assertEquals(5, set1.largest());
        
        // Test with negative numbers
        set1.add(-10);
        assertEquals(5, set1.largest());
        
        // Test with single element
        set1.clear();
        set1.add(7);
        assertEquals(7, set1.largest());
    }
    
    @Test
    @DisplayName("Test case for largest exception")
    public void testLargestException() {
        // Empty set should throw exception
        Exception exception = assertThrows(IntegerSetException.class, () -> {
            set1.largest();
        });
        
        String expectedMessage = "Set is empty";
        String actualMessage = exception.getMessage();
        
        assertTrue(actualMessage.contains(expectedMessage));
    }
    
    @Test
    @DisplayName("Test case for smallest")
    public void testSmallest() throws IntegerSetException {
        // Add elements and test
        set1.add(3);
        set1.add(1);
        set1.add(5);
        
        assertEquals(1, set1.smallest());
        
        // Test with negative numbers
        set1.add(-10);
        assertEquals(-10, set1.smallest());
        
        // Test with single element
        set1.clear();
        set1.add(7);
        assertEquals(7, set1.smallest());
    }
    
    @Test
    @DisplayName("Test case for smallest exception")
    public void testSmallestException() {
        // Empty set should throw exception
        Exception exception = assertThrows(IntegerSetException.class, () -> {
            set1.smallest();
        });
        
        String expectedMessage = "Set is empty";
        String actualMessage = exception.getMessage();
        
        assertTrue(actualMessage.contains(expectedMessage));
    }
    
    @Test
    @DisplayName("Test case for add")
    public void testAdd() {
        // Add elements to set
        set1.add(1);
        set1.add(2);
        set1.add(3);
        
        assertEquals(3, set1.length());
        assertTrue(set1.contains(1));
        assertTrue(set1.contains(2));
        assertTrue(set1.contains(3));
        
        // Add duplicate elements
        set1.add(1);
        assertEquals(3, set1.length()); // Length should remain the same
    }
    
    @Test
    @DisplayName("Test case for remove")
    public void testRemove() {
        // Add elements
        set1.add(1);
        set1.add(2);
        set1.add(3);
        
        // Remove existing element
        set1.remove(2);
        assertEquals(2, set1.length());
        assertFalse(set1.contains(2));
        
        // Try to remove non-existing element
        set1.remove(4);
        assertEquals(2, set1.length()); // Should remain the same
        
        // Remove all elements
        set1.remove(1);
        set1.remove(3);
        assertEquals(0, set1.length());
        assertTrue(set1.isEmpty());
    }
    
    @Test
    @DisplayName("Test case for union")
    public void testUnion() {
        // Prepare sets
        set1.add(1);
        set1.add(2);
        set1.add(3);
        
        set2.add(3);
        set2.add(4);
        set2.add(5);
        
        // Perform union
        set1.union(set2);
        
        // Check result
        assertEquals(5, set1.length());
        assertTrue(set1.contains(1));
        assertTrue(set1.contains(2));
        assertTrue(set1.contains(3));
        assertTrue(set1.contains(4));
        assertTrue(set1.contains(5));
    }
    
    @Test
    @DisplayName("Test case for intersect")
    public void testIntersect() {
        // Prepare sets
        set1.add(1);
        set1.add(2);
        set1.add(3);
        
        set2.add(3);
        set2.add(4);
        set2.add(5);
        
        // Perform intersection
        set1.intersect(set2);
        
        // Check result
        assertEquals(1, set1.length());
        assertTrue(set1.contains(3));
        assertFalse(set1.contains(1));
        assertFalse(set1.contains(2));
        assertFalse(set1.contains(4));
        assertFalse(set1.contains(5));
        
        // Test with no common elements
        set1.clear();
        set1.add(1);
        set1.add(2);
        
        set2.clear();
        set2.add(3);
        set2.add(4);
        
        set1.intersect(set2);
        assertEquals(0, set1.length());
        assertTrue(set1.isEmpty());
    }
    
    @Test
    @DisplayName("Test case for diff")
    public void testDiff() {
        // Prepare sets
        set1.add(1);
        set1.add(2);
        set1.add(3);
        
        set2.add(3);
        set2.add(4);
        set2.add(5);
        
        // Perform difference
        set1.diff(set2);
        
        // Check result (set1 - set2)
        assertEquals(2, set1.length());
        assertTrue(set1.contains(1));
        assertTrue(set1.contains(2));
        assertFalse(set1.contains(3));
        
        // Test with no common elements
        set1.clear();
        set1.add(1);
        set1.add(2);
        
        set2.clear();
        set2.add(3);
        set2.add(4);
        
        set1.diff(set2);
        assertEquals(2, set1.length());
        assertTrue(set1.contains(1));
        assertTrue(set1.contains(2));
        
        // Test with subset
        set1.clear();
        set1.add(1);
        set1.add(2);
        
        set2.clear();
        set2.add(1);
        set2.add(2);
        set2.add(3);
        
        set2.diff(set1);
        assertEquals(1, set2.length());
        assertTrue(set2.contains(3));
    }
    
    @Test
    @DisplayName("Test case for complement")
    public void testComplement() {
        // Prepare sets
        set1.add(1);
        set1.add(2);
        set1.add(3);
        
        set2.add(1);
        set2.add(2);
        set2.add(3);
        set2.add(4);
        set2.add(5);
        
        // Perform complement - set1 should contain elements in set2 but not in set1
        set1.complement(set2);
        
        // Check result
        assertEquals(2, set1.length());
        assertTrue(set1.contains(4));
        assertTrue(set1.contains(5));
        assertFalse(set1.contains(1));
        assertFalse(set1.contains(2));
        assertFalse(set1.contains(3));
        
        // Test with disjoint sets
        set1.clear();
        set1.add(1);
        set1.add(2);
        
        set2.clear();
        set2.add(3);
        set2.add(4);
        
        set1.complement(set2);
        assertEquals(2, set1.length());
        assertTrue(set1.contains(3));
        assertTrue(set1.contains(4));
    }
    
    @Test
    @DisplayName("Test case for isEmpty")
    public void testIsEmpty() {
        // New set should be empty
        assertTrue(set1.isEmpty());
        
        // Add elements
        set1.add(1);
        assertFalse(set1.isEmpty());
        
        // Clear set
        set1.clear();
        assertTrue(set1.isEmpty());
    }
    
    @Test
    @DisplayName("Test case for toString")
    public void testToString() {
        // Test empty set
        assertEquals("[]", set1.toString());
        
        // Test with elements
        set1.add(1);
        set1.add(2);
        set1.add(3);
        
        String result = set1.toString();
        assertTrue(result.contains("1"));
        assertTrue(result.contains("2"));
        assertTrue(result.contains("3"));
        
        // This test is implementation-dependent, but generally should match this pattern
        assertEquals("[1, 2, 3]", set1.toString());
    }
}