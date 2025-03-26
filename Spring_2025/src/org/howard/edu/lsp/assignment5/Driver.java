package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * IntegerSet class represents a mathematical set that holds only integers.
 * Ensures no duplicate elements and provides standard set operations.
 */
public class IntegerSet {
    // Store the set elements in an ArrayList.
    private List<Integer> set = new ArrayList<>();

    /**
     * Default Constructor creating an empty set.
     */
    public IntegerSet() {
    }

    /**
     * Constructor to initialize set with unique values from given ArrayList.
     * 
     * @param set Initial ArrayList of integers to create the set from
     */
    public IntegerSet(ArrayList<Integer> set) {
        // Ensures no duplicates are added
        for (Integer num : set) {
            this.add(num);
        }
    }

    /**
     * Clears all elements from the set.
     */
    public void clear() {
        set.clear();
    }

    /**
     * Returns the number of elements in the set.
     * 
     * @return Number of elements in the set
     */
    public int length() {
        return set.size();
    }

    /**
     * Checks if two sets are equal.
     * Two sets are equal if they contain the same values in any order.
     * 
     * @param o The object to compare with this set
     * @return true if sets are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        // Check if the object is an IntegerSet
        if (!(o instanceof IntegerSet)) return false;
        
        IntegerSet other = (IntegerSet) o;
        // Check if both sets contain the same elements
        return set.size() == other.set.size() && 
               set.containsAll(other.set);
    }

    /**
     * Checks if the set contains a specific value.
     * 
     * @param value The integer to check for in the set
     * @return true if the value is in the set, false otherwise
     */
    public boolean contains(int value) {
        return set.contains(value);
    }

    /**
     * Returns the largest element in the set.
     * 
     * @return The largest integer in the set
     * @throws RuntimeException if the set is empty
     */
    public int largest() {
        if (set.isEmpty()) {
            throw new RuntimeException("Cannot find largest of empty set");
        }
        return set.stream().max(Integer::compare).get();
    }

    /**
     * Returns the smallest element in the set.
     * 
     * @return The smallest integer in the set
     * @throws RuntimeException if the set is empty
     */
    public int smallest() {
        if (set.isEmpty()) {
            throw new RuntimeException("Cannot find smallest of empty set");
        }
        return set.stream().min(Integer::compare).get();
    }

    /**
     * Adds an item to the set if it's not already present.
     * 
     * @param item The integer to add to the set
     */
    public void add(int item) {
        if (!set.contains(item)) {
            set.add(item);
        }
    }

    /**
     * Removes an item from the set if it exists.
     * 
     * @param item The integer to remove from the set
     */
    public void remove(int item) {
        set.remove(Integer.valueOf(item));
    }

    /**
     * Performs a union operation, adding all elements from another set.
     * 
     * @param intSetb The set to union with the current set
     */
    public void union(IntegerSet intSetb) {
        for (Integer num : intSetb.set) {
            if (!this.set.contains(num)) {
                this.set.add(num);
            }
        }
    }

    /**
     * Performs an intersection operation, keeping only common elements.
     * 
     * @param intSetb The set to intersect with the current set
     */
    public void intersect(IntegerSet intSetb) {
        set.retainAll(intSetb.set);
    }

    /**
     * Performs a set difference operation, removing elements found in another set.
     * 
     * @param intSetb The set to subtract from the current set
     */
    public void diff(IntegerSet intSetb) {
        set.removeAll(intSetb.set);
    }

    /**
     * Performs a complement operation, keeping elements not in another set.
     * 
     * @param intSetb The set to complement against
     */
    public void complement(IntegerSet intSetb) {
        // Create a copy of current set
        List<Integer> tempSet = new ArrayList<>(set);
        
        // Remove all elements from the other set
        tempSet.removeAll(intSetb.set);
        
        // Clear current set and add complementary elements
        set.clear();
        set.addAll(tempSet);
    }

    /**
     * Checks if the set is empty.
     * 
     * @return true if the set has no elements, false otherwise
     */
    public boolean isEmpty() {
        return set.isEmpty();
    }

    /**
     * Returns a string representation of the set.
     * 
     * @return String representation of the set
     */
    @Override
    public String toString() {
        return set.toString();
    }
}
