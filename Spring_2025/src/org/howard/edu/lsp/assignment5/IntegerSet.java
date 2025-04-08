package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a mathematical set of unique integers with standard set operations.
 */
public class IntegerSet {
    // Internal list to store unique integers
    private List<Integer> set = new ArrayList<>();

    /**
     * Default constructor that initializes an empty set.
     */
    public IntegerSet() {}

    /**
     * Constructor that initializes the set with unique values from a given list.
     * 
     * @param initialValues List of integers to initialize the set.
     */
    public IntegerSet(List<Integer> initialValues) {
        for (Integer num : initialValues) {
            add(num); // Ensures uniqueness while adding
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
     * @return The size of the set.
     */
    public int length() {
        return set.size();
    }

    /**
     * Checks if two sets are equal (contain the same elements, regardless of order).
     * 
     * @param obj The object to compare against.
     * @return true if sets are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof IntegerSet)) return false;
        IntegerSet other = (IntegerSet) obj;
        return set.size() == other.set.size() && set.containsAll(other.set);
    }

    /**
     * Checks if the set contains a specific value.
     * 
     * @param value The integer to check for.
     * @return true if the value is present, false otherwise.
     */
    public boolean contains(int value) {
        return set.contains(value);
    }

    /**
     * Returns the largest value in the set.
     * 
     * @return The largest integer.
     * @throws RuntimeException if the set is empty.
     */
    public int largest() {
        if (set.isEmpty()) {
            throw new RuntimeException("Cannot find the largest element in an empty set.");
        }
        return set.stream().max(Integer::compare).get(); // Use get() since the set is not empty
    }

    /**
     * Returns the smallest value in the set.
     * 
     * @return The smallest integer.
     * @throws RuntimeException if the set is empty.
     */
    public int smallest() {
        if (set.isEmpty()) {
            throw new RuntimeException("Cannot find the smallest element in an empty set.");
        }
        return set.stream().min(Integer::compare).get(); // Use get() since the set is not empty
    }

    /**
     * Adds an element to the set if it's not already present.
     * 
     * @param item The integer to add.
     */
    public void add(int item) {
        if (!set.contains(item)) {
            set.add(item);
        }
    }

    /**
     * Removes an element from the set if it exists.
     * 
     * @param item The integer to remove.
     */
    public void remove(int item) {
        set.remove(Integer.valueOf(item));
    }

    /**
     * Performs a union operation, adding all elements from another set.
     * 
     * @param otherSet The set to merge with.
     */
    public void union(IntegerSet otherSet) {
        for (Integer num : otherSet.set) {
            add(num);
        }
    }

    /**
     * Performs an intersection operation, keeping only common elements.
     * 
     * @param otherSet The set to intersect with.
     */
    public void intersect(IntegerSet otherSet) {
        set.retainAll(otherSet.set);
    }

    /**
     * Performs a difference operation, removing elements found in another set.
     * 
     * @param otherSet The set to subtract from this set.
     */
    public void diff(IntegerSet otherSet) {
        set.removeAll(otherSet.set);
    }

    /**
     * Performs a complement operation: modifies this set to only include elements
     * that are in the other set but not in this set.
     * 
     * @param otherSet The set to compare against.
     */
    public void complement(IntegerSet otherSet) {
        List<Integer> result = new ArrayList<>();
        for (Integer num : otherSet.set) {
            if (!this.set.contains(num)) {
                result.add(num);
            }
        }
        this.set = result;
    }

    /**
     * Checks if the set is empty.
     * 
     * @return true if the set has no elements, false otherwise.
     */
    public boolean isEmpty() {
        return set.isEmpty();
    }

    /**
     * Returns a string representation of the set.
     * 
     * @return A string representing the set's contents.
     */
    @Override
    public String toString() {
        return set.toString();
    }
}
