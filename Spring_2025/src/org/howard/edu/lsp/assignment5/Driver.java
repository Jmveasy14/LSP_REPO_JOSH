package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;

/**
 * Driver class to test the functionality of IntegerSet.
 */
public class Driver {
    public static void main(String[] args) {
        // Creating and populating the first set
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        
        System.out.println("Set1: " + set1);
        System.out.println("Set1 size: " + set1.length());
        System.out.println("Smallest value in Set1: " + set1.smallest());
        System.out.println("Largest value in Set1: " + set1.largest());
        System.out.println("Does Set1 contain 2? " + set1.contains(2));

        // Creating and populating the second set
        IntegerSet set2 = new IntegerSet();
        set2.add(3);
        set2.add(4);
        set2.add(5);
        System.out.println("\nSet2: " + set2);

        // Demonstrating union operation
        IntegerSet unionSet = new IntegerSet();
        unionSet.union(set1);
        unionSet.union(set2);
        System.out.println("\nUnion of Set1 and Set2: " + unionSet);

        // Demonstrating intersection operation
        IntegerSet intersectionSet = new IntegerSet();
        intersectionSet.union(set1); // Copy set1
        intersectionSet.intersect(set2);
        System.out.println("\nIntersection of Set1 and Set2: " + intersectionSet);

        // Demonstrating difference operation
        IntegerSet differenceSet = new IntegerSet();
        differenceSet.union(set1); // Copy set1
