package org.howard.edu.lsp.assignment6;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IntegerSetTest {
    private IntegerSet set1;
    private IntegerSet set2;

    @BeforeEach
    public void setUp() {
        set1 = new IntegerSet();
        set2 = new IntegerSet();
    }

    @Test
    public void testAddAndContains() {
        set1.add(1);
        set1.add(2);
        set1.add(2); // duplicate
        assertTrue(set1.contains(1));
        assertTrue(set1.contains(2));
        assertEquals(2, set1.length()); // duplicates not added
    }

    @Test
    public void testRemove() {
        set1.add(10);
        set1.add(20);
        set1.remove(10);
        assertFalse(set1.contains(10));
        assertTrue(set1.contains(20));
    }

    @Test
    public void testClearAndIsEmpty() {
        set1.add(5);
        set1.clear();
        assertTrue(set1.isEmpty());
    }

    @Test
    public void testLength() {
        set1.add(5);
        set1.add(10);
        assertEquals(2, set1.length());
    }

    @Test
    public void testEquals() {
        set1 = new IntegerSet(Arrays.asList(1, 2, 3));
        set2 = new IntegerSet(Arrays.asList(3, 2, 1));
        assertTrue(set1.equals(set2));
    }

    @Test
    public void testLargestAndSmallest() throws IntegerSetException {
        set1 = new IntegerSet(Arrays.asList(1, 3, 5, 2));
        assertEquals(5, set1.largest());
        assertEquals(1, set1.smallest());
    }

    @Test
    public void testLargestException() {
        assertThrows(IntegerSetException.class, () -> {
            set1.largest();
        });
    }

    @Test
    public void testSmallestException() {
        assertThrows(IntegerSetException.class, () -> {
            set1.smallest();
        });
    }

    @Test
    public void testUnion() {
        set1 = new IntegerSet(Arrays.asList(1, 2));
        set2 = new IntegerSet(Arrays.asList(2, 3));
        set1.union(set2);
        assertTrue(set1.equals(new IntegerSet(Arrays.asList(1, 2, 3))));
    }

    @Test
    public void testIntersect() {
        set1 = new IntegerSet(Arrays.asList(1, 2, 3));
        set2 = new IntegerSet(Arrays.asList(2, 3, 4));
        set1.intersect(set2);
        assertTrue(set1.equals(new IntegerSet(Arrays.asList(2, 3))));
    }

    @Test
    public void testDiff() {
        set1 = new IntegerSet(Arrays.asList(1, 2, 3));
        set2 = new IntegerSet(Arrays.asList(2));
        set1.diff(set2);
        assertTrue(set1.equals(new IntegerSet(Arrays.asList(1, 3))));
    }

    @Test
    public void testComplement() {
        set1 = new IntegerSet(Arrays.asList(1, 2));
        set2 = new IntegerSet(Arrays.asList(1, 2, 3, 4));
        set1.complement(set2);
        assertTrue(set1.equals(new IntegerSet(Arrays.asList(3, 4))));
    }

    @Test
    public void testToString() {
        set1 = new IntegerSet(Arrays.asList(5, 6));
        String str = set1.toString();
        assertTrue(str.contains("5") && str.contains("6"));
    }
}
